package Sprint1_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.junit.Before;
import org.junit.Test;

import Sprint1_0.product.Board;
import Sprint1_0.product.BottomPanel;
import Sprint1_0.product.GameSetup;

public class TestBottomPanel {
      private BottomPanel bottomPanel;
    private Board board; // Replace with your actual Board class
    private GameSetup gameSetup; // Replace with your actual GameSetup class

    @Before
    public void setUp() {
        // Create a new instance of BottomPanel for each test case
        board = new Board(gameSetup); // Replace with your actual Board instance
        gameSetup = new GameSetup(); // Replace with your actual GameSetup instance
        bottomPanel = new BottomPanel(board, gameSetup);
    }

    @Test
    public void testGetPanel() {
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
}
