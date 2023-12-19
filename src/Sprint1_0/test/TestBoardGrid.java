package Sprint1_0.test;
import Sprint1_0.product.Board;
import Sprint1_0.product.BoardGrid;
import Sprint1_0.product.GameSetup;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Color;


public class TestBoardGrid {
    private BoardGrid boardGrid;
    private Board board; // Replace with actual Board class
    private GameSetup gameSetup; // Replace with actual GameSetup class

    @Before
    public void setUp() {
        // Create a new instance of BoardGrid for each test case
        board = new Board(gameSetup); // Replace with Board instance
        gameSetup = new GameSetup(); // Replace with GameSetup instance
        boardGrid = new BoardGrid(board, gameSetup);
    }

    @Test
    public void testCalculateCells() {
        // Call the calculateCells() method to calculate cell positions
        boardGrid.calculateCells();

        // Perform assertions to check the cells array
        Rectangle[][] cells = boardGrid.getCells();
        assertNotNull(cells);
        int gridSize = boardGrid.getGridWidth();
        int margin = boardGrid.getMargin();
        int cellCount = cells.length;

        // Assert that cell positions are correctly calculated
        for (int row = 0; row < cellCount; row++) {
            for (int column = 0; column < cellCount; column++) {
                Rectangle cell = cells[row][column];
                assertNotNull(cell);
                assertEquals(column * gridSize + margin, cell.x);
                assertEquals(row * gridSize + margin, cell.y);
                assertEquals(gridSize, cell.width);
                assertEquals(gridSize, cell.height);
            }
        }
    }

    @Test
    public void testPaintComponent() {
        // Create a dummy JPanel to simulate the paintComponent call
        JPanel dummyPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                boardGrid.paintComponent(g);
            }
        };

        // Create a dummy Graphics object
        Graphics dummyGraphics = dummyPanel.getGraphics();

        // Call paintComponent method to paint the boardGrid
        boardGrid.paintComponent(dummyGraphics);

        // Add assertions to check that paintComponent executed without errors
        assertNotNull(dummyGraphics);
        assertEquals(Color.BLACK, dummyGraphics.getColor());
    }
}
