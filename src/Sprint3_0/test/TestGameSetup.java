package Sprint3_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import Sprint1_0.product.Board;
import Sprint3_0.product.GameSetup;
import Sprint3_0.product.TopPanel;
import Sprint3_0.product.BottomPanel;
import Sprint3_0.product.LeftPanel;
import Sprint3_0.product.RightPanel;
import Sprint3_0.product.SOSGrid;
import Sprint3_0.product.GUI;


public class TestGameSetup {
    private TopPanel topPanel;
    private Board board; // Replace with your actual Board class
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
        gameSetup.setGameboard(0, 0, "SOS");

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
    @Test
    public void testGetTopPanel() {
        // Check if the getPanel() method returns a non-null JPanel
        JPanel panel = topPanel.getPanel();
        assertNotNull(panel);
    }



    //------RIGHT PANEL-----
    @Test
    public void testGetPanel() {
        // Check if the getPanel() method returns a non-null JPanel
        JPanel panel = rightPanel.getPanel();
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

    //------Left PANEl
    @Test
    void testBluePlayer() {
        GameSetup playerTurn;
        JPanel panel = leftPanel.getPanel();

        assertNotNull(panel);

        // Assuming you have a JLabel with the text "BluePlayer"
        JLabel playerLabel = (JLabel) panel.getComponent(0);
        assertEquals("BluePlayer", playerLabel.getText());

        // Assuming you have two radio buttons for "S" and "O"
        JRadioButton buttonS = (JRadioButton) panel.getComponent(2);
        JRadioButton buttonO = (JRadioButton) panel.getComponent(4);

        assertNotNull(buttonS);
        assertNotNull(buttonO);
        assertTrue(buttonS.isSelected());
        assertFalse(buttonO.isSelected());

        // Simulate a button click on "O"
        ActionEvent mockActionEvent = new ActionEvent(buttonO, ActionEvent.ACTION_PERFORMED, "O");
        for (ActionListener listener : buttonO.getActionListeners()) {
            listener.actionPerformed(mockActionEvent);
        }

        // Assuming you have a method like SOSGrid.getCurrentPlayerChoice()
        assertEquals('O', SOSGrid.getCurrentPlayerChoice());

        // You can add more assertions based on your specific requirements
    }

    //bottom panel
    @Test
    public void testGetBottomPanel() {
        // Check if the getPanel() method returns a non-null JPanel
        JPanel panel = bottomPanel.getPanel();
        assertNotNull(panel);

        // Check if the panel contains a JLabel
        JLabel userTurnLabel = findJLabel(panel);
        assertNotNull(userTurnLabel);
        assertEquals("Current turn(____)", userTurnLabel.getText());
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

}