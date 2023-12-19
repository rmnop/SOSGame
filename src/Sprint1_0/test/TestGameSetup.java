package Sprint1_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import Sprint1_0.product.GameSetup;
import Sprint1_0.product.TopPanel;

public class TestGameSetup {
    
    private GameSetup gameSetup;
    private JRadioButton simple;
    private JRadioButton general;

    @Before
    public void setUp() {
        // Create a new instance of GameSetup for each test case
        gameSetup = new GameSetup();
        simple =  new JRadioButton("Simple");
        general =  new JRadioButton("General");
    }

    @Test
    public void testBoardSize() {
        // Check the initial state of the GameSetup object
        assertEquals(3, gameSetup.getGameBoardSize());
        assertEquals(3, gameSetup.getDefaultSize());
        assertEquals(10, gameSetup.getMaxSize());
        assertEquals(0, gameSetup.gameMode);
        
        // Check the initial state of the game board (should be empty)
        char[][] gameBoard = gameSetup.getGameboard();
        assertNotNull(gameBoard);
        assertEquals(3, gameBoard.length);
        assertEquals(3, gameBoard[0].length);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(' ', gameBoard[row][col]);
            }
        }
    }

    @Test
    public void testSetGameboardSize() {
        // Set the game board size to 3x3
        gameSetup.setGameboardSize(3);
        assertEquals(3, gameSetup.getGameBoardSize());
        
        // Check the state of the game board after resizing (should be empty)
        char[][] gameBoard = gameSetup.getGameboard();
        assertNotNull(gameBoard);
        assertEquals(3, gameBoard.length);
        assertEquals(3, gameBoard[0].length);
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                assertEquals(' ', gameBoard[row][col]);
            }
        }
    }

    @Test
    public void testSetGameMode() {
        // Set the game mode to 1
        gameSetup.setGameMode(1);
        assertEquals(1, gameSetup.gameMode);
    }


    
    @Test
    public void testSetPlacement() {
        // Set a specific cell in the game board
        gameSetup.setGameboard(1, 1, "X");
        assertEquals('X', gameSetup.getGameboard(1, 1));
    }

}
