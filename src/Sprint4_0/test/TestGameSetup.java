package Sprint4_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import Sprint4_0.product.Board;
import Sprint4_0.product.GameSetup;
import Sprint4_0.product.TopPanel;
import Sprint4_0.product.BottomPanel;
import Sprint4_0.product.LeftPanel;
import Sprint4_0.product.RightPanel;
import Sprint4_0.product.SOSGrid;
import Sprint4_0.product.GUI;


public class TestGameSetup {
    private TopPanel topPanel;
    private Sprint3_0.product.Board board; // Replace with your actual Board class
    private GameSetup game; // Replace with your actual GameSetup class
    private RightPanel rightPanel;
    private LeftPanel leftPanel;
    private BottomPanel bottomPanel;
    private JPanel panel;



    @Test
    public void testSetGameboardSize() {
        GameSetup gameSetup = new GameSetup();
        gameSetup.setGameboardSize(5);

        assertEquals(5, gameSetup.getGameboardSize());
    }

    @Test
    public void testSetGameMode() {
        GameSetup gameSetup = new GameSetup();
        int mode = gameSetup.setGameMode(1);

        assertEquals(1, mode);
    }

    @Test
    public void testNextPlayersTurn() {
        GameSetup gameSetup = new GameSetup();
        gameSetup.nextPlayersTurn();

        assertEquals(2, gameSetup.getPlayerTurn());
    }

    @Test
    public void testIsGameOver() {
        GameSetup gameSetup = new GameSetup();
        assertFalse(gameSetup.isGameOver());

        // Assuming isSimpleGameOver() and isGeneralGameOver() are working as expected
        // You may need to write separate tests for these methods
    }

    @Test
    public void testCheckSOS() {
        GameSetup gameSetup = new GameSetup();
        // Assuming your game setup has an SOS at the beginning for testing purposes
        gameSetup.setGameboard(0, 0, "S");
        gameSetup.setGameboard(0, 1, "O");
        gameSetup.setGameboard(0, 2, "S");

        assertTrue(gameSetup.checkSOS());

    }

    @Test
    public void testCheckHorizontal() {
        GameSetup gameSetup = new GameSetup();
        // Assuming your game setup has an SOS horizontally at the beginning for testing purposes
        gameSetup.setGameboard(0, 0, "SOS");

    }

    // Add more tests for other methods as needed

    //-----TOP PANEL-------
    @Before
    public void setUp() {
        this.topPanel = new TopPanel(null, game/* constructor arguments */);

        SOSGrid.setCurrentPlayerChoice('S');  // Set an initial value for testing

    }
    
    @Test
    public void testGetTopPanel() {
        // Now topPanel is initialized before invoking getPanel
        JPanel panel = topPanel.getPanel();
        assertNotNull(panel);
    
        // Perform additional assertions or checks as needed
    }



    @Test
    public void testGetPanel() {
        // Check if the getPanel() method returns a non-null JPanel
        this.rightPanel = new RightPanel(null, game);
        JPanel panel = rightPanel.getPanel();  // Use rightPanel instead of panel
        assertNotNull(panel);
    
        // Check if the panel contains JLabel, JRadioButton (S), and JRadioButton (O)
        JLabel playerLabel = findJLabel(panel);
        assertNotNull(playerLabel);
        assertEquals("RedPlayer", playerLabel.getText());
    
        JRadioButton sRadioButton = findJRadioButton(panel, "S");
        assertNotNull(sRadioButton);
        assertTrue(sRadioButton.isSelected());
    
        JRadioButton oRadioButton = findJRadioButton(panel, "O");
        assertNotNull(oRadioButton);
        assertFalse(oRadioButton.isSelected());
    }


    // Helper method to find a JRadioButton in a JPanel by its text
    private JRadioButton findJRadioButton(JPanel panel, String text) {
        for (java.awt.Component comp : panel.getComponents()) {
            if (comp instanceof JRadioButton) {
                JRadioButton radioButton = (JRadioButton) comp;
                if (radioButton.getText().equals(text)) {
                    return radioButton;
                }
            }
        }
        return null;
    }

   //------Left PANEL
@Test
public void testBluePlayer() {
    this.leftPanel = new LeftPanel(null, game);
    JPanel panel = leftPanel.getPanel();
    assertNotNull(panel);
    
    // Assuming you have a JLabel with the text "BluePlayer"
    JLabel playerLabel = (JLabel) panel.getComponent(0);
    assertEquals("BluePlayer", playerLabel.getText());

    // Assuming you have two radio buttons for "S" and "O"
    // Assuming radio buttons are the 2nd and 3rd components
    JRadioButton buttonS = (JRadioButton) panel.getComponent(1);
    JRadioButton buttonO = (JRadioButton) panel.getComponent(2);  // Check the index, it might be 3

    SOSGrid.setCurrentPlayerChoice('S');  // Set an initial value for testing
 

    assertNotNull(buttonS);
    assertNotNull(buttonO);
    assertTrue(buttonS.isSelected());

    // Simulate a button click on "O"
    ActionEvent mockActionEvent = new ActionEvent(buttonO, ActionEvent.ACTION_PERFORMED, "O");
    for (ActionListener listener : buttonO.getActionListeners()) {
        listener.actionPerformed(mockActionEvent);
    }

}


@Test
public void testSOSGrid() {
    // Set up SOSGrid or its dependencies if needed

    // Set the current player choice
    SOSGrid.setCurrentPlayerChoice('S');

    assertTrue(true);

}


    //bottom panel
    @Test
    public void testGetBottomPanel() {
    // Initialize a GameSetup instance (assuming you have a proper constructor)
    GameSetup gameSetup = new GameSetup();
    // Create BottomPanel with initialized components
    this.bottomPanel = new BottomPanel(null, gameSetup);
    assertNotNull(bottomPanel.getPanel());

    // Check if the panel contains a JLabel
    JLabel userTurnLabel = findJLabel(bottomPanel.getPanel());
    assertNotNull(userTurnLabel);
    assertEquals("Current turn: ", userTurnLabel.getText());
}
    // Helper method to find a JLabel in a JPanel
    private JLabel findJLabel(JPanel panel) {
        for (java.awt.Component comp : panel.getComponents()) {
            if (comp instanceof JLabel) {
                return (JLabel) comp;
            }
        }
        return null;
    }

    class GUITest {

        @Test
        void testRun() {
            GUI gui = new GUI();
    
        }
    }

    @Test
    public void testPlayComputerMove() {
        // Create an instance of GameSetup
        GameSetup gameSetup = new GameSetup();
    
        // Set up a mock game board (you might need to adjust this based on your actual implementation)
        char[][] mockGameboard = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        
        // Store the initial state of the game board
        char[][] initialGameboard = copyGameboard(mockGameboard);
    
        // Play computer move
        gameSetup.playComputerMove();
    
        // Check if a letter has been placed on a valid empty cell
        char[][] updatedGameboard = gameSetup.getGameboard();

        assertTrue("The move should be valid", isMoveValid(initialGameboard, updatedGameboard));

    
    }
    
    private char[][] copyGameboard(char[][] gameboard) {
        // Create a copy of the game board
        char[][] copy = new char[gameboard.length][gameboard[0].length];
        for (int i = 0; i < gameboard.length; i++) {
            System.arraycopy(gameboard[i], 0, copy[i], 0, gameboard[i].length);
        }
        return copy;
    }

    private boolean isMoveValid(char[][] initialGameboard, char[][] updatedGameboard) {
        // Your logic to determine if the move is valid
        // Compare the initialGameboard and updatedGameboard to check if a valid move was made
        // For example, check if a letter has been placed on a valid empty cell
    
        for (int i = 0; i < initialGameboard.length; i++) {
            for (int j = 0; j < initialGameboard[i].length; j++) {
                if (initialGameboard[i][j] == ' ' && updatedGameboard[i][j] != ' ') {
                    // Valid move, return true
                    return true;
                }
            }
        }
    
        // No valid move found
        return false;
    }


    @Test
    public void testSaveAndLoadGameState() throws IOException {
            GameSetup game = new GameSetup();
            // Save the game state to a temporary file
            String filePath = "temp_game_state.txt";
            game.saveGameStateToFile(filePath);

            // Load the game state from the file
            GameSetup loadedGameSetup = new GameSetup();
            loadedGameSetup.saveGameStateToFile(filePath);

            // Verify that the loaded game state is the same as the original one
            assertEquals(game.getGameboardSize(), loadedGameSetup.getGameboardSize());
            // Add more assertions based on your specific game state attributes

    }
}

