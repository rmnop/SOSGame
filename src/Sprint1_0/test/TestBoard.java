package Sprint1_0.test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import javax.swing.JFrame;
import java.awt.BorderLayout;

import Sprint1_0.product.Board;
import Sprint1_0.product.BoardGrid;
import Sprint1_0.product.GameSetup;


public class TestBoard {

    private Board board;
    private GameSetup gameSetup; // Replace with your actual GameSetup implementation

    @Before
    public void setUp() {
        // Create a new instance of Board for each test case
        gameSetup = new GameSetup(); // Replace with your actual GameSetup implementation
        board = new Board(gameSetup);
    }

    @After
	public void tearDown() throws Exception {
	}

    @Test
    public void testGUI() {
        // Call the GUI() method to create a JFrame
        JFrame frame = board.GUI();

        // Perform assertions to test the JFrame and its components
        assertNotNull(frame);
        assertEquals("SOS", frame.getTitle());
        assertTrue(frame.getContentPane().getLayout() instanceof BorderLayout);
        assertNotNull(frame.getContentPane().getLayout());


        // Ensure that the JFrame is visible
        assertTrue(frame.isVisible());

        // Close the JFrame
        frame.dispose();
    }
}

