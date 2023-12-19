package Sprint1_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import org.junit.Before;
import org.junit.Test;

import Sprint1_0.product.Board;
import Sprint1_0.product.GameSetup;
import Sprint1_0.product.LeftPanel;

public class TestLeftPanel {
    private LeftPanel leftPanel;
    private Board board; // Replace with your actual Board class
    private GameSetup gameSetup; // Replace with your actual GameSetup class

    @Before
    public void setUp() {
        // Create a new instance of LeftPanel for each test case
        board = new Board(gameSetup); // Replace with your actual Board instance
        gameSetup = new GameSetup(); // Replace with your actual GameSetup instance
        leftPanel = new LeftPanel(board, gameSetup, gameSetup);
    }

    @Test
    public void testGetPanel() {
        // Check if the getPanel() method returns a non-null JPanel
        JPanel panel = leftPanel.getPanel();
        assertNotNull(panel);

        // Check if the panel contains JLabel, JRadioButton (S), and JRadioButton (O)
        JLabel playerLabel = findJLabel(panel);
        assertNotNull(playerLabel);
        assertEquals("BluePlayer", playerLabel.getText());

        JRadioButton sRadioButton = findJRadioButton(panel, "S");
        assertNotNull(sRadioButton);
        assertTrue(sRadioButton.isSelected());

        JRadioButton oRadioButton = findJRadioButton(panel, "O");
        assertNotNull(oRadioButton);
        assertFalse(oRadioButton.isSelected());
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
}
