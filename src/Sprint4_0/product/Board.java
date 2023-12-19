package Sprint4_0.product;
import java.awt.*;
import javax.swing.*;


public class Board {
    private final TopPanel gameStart;
    private final LeftPanel bluePlayer;
    private final RightPanel redPlayer;
    private final BottomPanel userTurn;
    private final BoardGrid boardPanel;
    private final JFrame frame;

    public Board(GameSetup gameSetup) {
      this.gameStart = new TopPanel(this, gameSetup);
      this.bluePlayer = new LeftPanel(this, gameSetup);
      this.redPlayer = new RightPanel(this, gameSetup);
      this.userTurn = new BottomPanel(this, gameSetup);
      this.boardPanel = new BoardGrid(this, gameSetup);
      this.frame = GUI();
    }

    public JFrame GUI() {
        JFrame frame = new JFrame("SOS");
        frame.add(gameStart.getPanel(), BorderLayout.NORTH);
        frame.add(bluePlayer.getPanel(), BorderLayout.WEST);
        frame.add(redPlayer.getPanel(), BorderLayout.EAST);
        frame.add(userTurn.getPanel(), BorderLayout.SOUTH);
        frame.add(boardPanel, BorderLayout.CENTER);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }

    public void shutdown() {
        frame.dispose();
        System.exit(0);
    }

    public JFrame getFrame() {
        return frame;
    }

    public int setGridSize(int gridSize) {
        return gridSize;
    }

    public void calculateCells() {
        boardPanel.calculateCells(); 
    }

    public void repaint() {
        boardPanel.repaint();
    }

    public int getGridWidth() {
        return boardPanel.getGridWidth();
    }

    public int getMargin() {
        return boardPanel.getMargin();
    }

    public void getCells() {
        boardPanel.getCells();
    }

    public void updateStatusLabel() {
        userTurn.updateStatusLabel(); }
    
}

