package Sprint1_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import org.junit.Before;
import org.junit.Test;

import Sprint1_0.product.Board;
import Sprint1_0.product.GameSetup;
import Sprint1_0.product.TopPanel;

public class TestTopPanel {
    private TopPanel topPanel;
    private Board board; // Replace with your actual Board class
    private GameSetup gameSetup; // Replace with your actual GameSetup class

    @Before
    public void setUp() {
        // Create a new instance of TopPanel for each test case
        board = new Board(gameSetup); // Replace with your actual Board instance
        gameSetup = new GameSetup(); // Replace with your actual GameSetup instance
        topPanel = new TopPanel(board, gameSetup);
    }

    @Test
    public void testGetPanel() {
        // Check if the getPanel() method returns a non-null JPanel
        JPanel panel = topPanel.getPanel();
        assertNotNull(panel);
    }


}
