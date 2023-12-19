package Sprint4_0.product;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.util.List;

public class BoardGrid extends JPanel  {
    private final Board board;
    private final GameSetup game;
    private final int gridSize;
    private Rectangle[][] cells;
    private int margin;

    //creates board object and size of the board in the panel
    public BoardGrid(Board board, GameSetup game) {
        this.game = game;
        this.board = board;
        this.gridSize = 30;
        int margin = 20;
        int gridCells = game.getMaximumSize();
        int size = gridCells * gridSize + margin;
        this.setPreferredSize(new Dimension(size, size));

        SOSGrid listener = new SOSGrid(board, game);
        this.addMouseListener(listener);
        calculateCells();

}

    
//calculates the how many cells after inputting number
public void calculateCells() {
    int gridCells = game.getGameboardSize();
    int size = gridCells * gridSize;
    margin = (getPreferredSize().width - size) / 2;
    cells = new Rectangle[gridCells][gridCells];
    
    int x = margin;
    int y = margin;
    for (int row = 0; row < gridCells; row++) {
        for (int column = 0; column < gridCells; column++) {
            cells[row][column] = new Rectangle(x, y, gridSize, gridSize);
            x += gridSize;
        }
        x = margin;
        y += gridSize;
    }
}




//paints board onto frame
@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    g2d.setColor(Color.BLACK);

    char[][] gameboard = game.getGameboard();
    for (int row = 0; row < cells.length; row++) {
        for (int column = 0; column < cells[row].length; column++) {
            Rectangle r = cells[row][column];
            g2d.drawRect(r.x, r.y, r.width, r.height);
            
            String text = Character.toString(gameboard[row][column]);
            FontMetrics fm = g2d.getFontMetrics();
            Rectangle2D r2d = fm.getStringBounds(text, g2d);
            int x = (r.width - (int) r2d.getWidth()) / 2 + r.x;
            int y = (r.height - (int) r2d.getHeight()) / 2 + fm.getAscent() + r.y;
            g.drawString(text, x, y);

    }

    List<SOSLine> lineSegments = game.getLineSegments();
        for (SOSLine segment : lineSegments) {
            Coordinate start = segment.getStartCoordinate();
            Coordinate end = segment.getEndCoordinate();
            Rectangle sr = cells[start.getRow()][start.getColumn()];
            Rectangle er = cells[end.getRow()][end.getColumn()];
            int spx = sr.x + sr.width / 2;
            int spy = sr.y + sr.height / 2;
            int epx = er.x + er.width / 2;
            int epy = er.y + er.height / 2;
            g2d.setColor(segment.getLineColor());
            g2d.drawLine(spx, spy, epx, epy);
        }
    }
}

    public int getGridWidth() {
        return gridSize; }

    public int getMargin() {
        return margin; }

    public Rectangle[][] getCells() {
        return cells;
    }
}

