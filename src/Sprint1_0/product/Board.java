package Sprint1_0.product;
import java.awt.*;
import java.awt.event.MouseAdapter;

import javax.swing.*;


public class Board {
    private final TopPanel gameStart;
    private final LeftPanel bluePlayer;
    private final RightPanel redPlayer;
    private final BottomPanel userTurn;
    private final BoardGrid boardPanel;
    private final JFrame frame;

    public Board(GameSetup game) {
      this.gameStart = new TopPanel(this, game);
      this.bluePlayer = new LeftPanel(this, game, game);
      this.redPlayer = new RightPanel(this, game, game);
      this.userTurn = new BottomPanel(this, game);
      this.boardPanel = new BoardGrid(this, game);
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
}
