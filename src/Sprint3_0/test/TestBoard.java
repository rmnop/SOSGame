package Sprint3_0.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.events.MouseEvent;

import Sprint3_0.product.GameSetup;
import Sprint3_0.product.Board;
import Sprint3_0.product.BoardGrid;
import Sprint3_0.product.Coordinate;
import Sprint3_0.product.SOSGrid;
import Sprint3_0.product.SOSLine;

public class TestBoard {
    //-----board test
    class BoardTest {

        @Test
        void testSetGridSize() {
            GameSetup gameSetup = new GameSetup();
            Board board = new Board(gameSetup);
    
            int newSize = 5;
            int result = board.setGridSize(newSize);
    
            assertEquals(newSize, result);
        }
    
        @Test
        void testCalculateCells() {
            GameSetup gameSetup = new GameSetup();
            Board board = new Board(gameSetup);
    
            // Assuming calculateCells() modifies some internal state
            board.calculateCells();
    
            // Add assertions based on the expected behavior of calculateCells()
        }
    
        @Test
        void testRepaint() {
            GameSetup gameSetup = new GameSetup();
            Board board = new Board(gameSetup);
    
            // Assuming repaint() does something meaningful
            board.repaint();
    
            // Add assertions based on the expected behavior of repaint()
        }
    
        @Test
        void testGetGridWidth() {
            GameSetup gameSetup = new GameSetup();
            Board board = new Board(gameSetup);
    
            int gridWidth = board.getGridWidth();
    
            // Add assertions based on the expected behavior of getGridWidth()
        }
    
        @Test
        void testGetMargin() {
            GameSetup gameSetup = new GameSetup();
            Board board = new Board(gameSetup);
    
            int margin = board.getMargin();
    
            // Add assertions based on the expected behavior of getMargin()
        }
    
        @Test
        void testGetCells() {
            GameSetup gameSetup = new GameSetup();
            Board board = new Board(gameSetup);
    
            // Assuming getCells() returns some meaningful data
            board.getCells();
    
            // Add assertions based on the expected behavior of getCells()
        }
    
        // Add more tests for other methods as needed
    
    }


    //------ board grid test
    class BoardGridTest {

        @Test
        void testCalculateCells() {
            Board board = new Board(new GameSetup());
            GameSetup game = new GameSetup();
            BoardGrid boardGrid = new BoardGrid(board, game);
    
            boardGrid.calculateCells();
    
            // Assuming getGridWidth and getMargin methods are working correctly
            int gridSize = boardGrid.getGridWidth();
            int margin = boardGrid.getMargin();
            Rectangle[][] cells = boardGrid.getCells();
    
            assertNotNull(cells);
            assertEquals(game.getGameboardSize(), cells.length);
    
            for (Rectangle[] row : cells) {
                for (Rectangle cell : row) {
                    assertNotNull(cell);
                    assertEquals(gridSize, cell.width);
                    assertEquals(gridSize, cell.height);
                }
            }
    
            // Assuming some specific calculations based on grid size and margin
            // Add more assertions based on the expected behavior of calculateCells()
        }
    }
    
    class CoordinateTest {

    @Test
    void testHashCode() {
        Coordinate coord1 = new Coordinate(1, 2);
        Coordinate coord2 = new Coordinate(1, 2);

        assertEquals(coord1.hashCode(), coord2.hashCode());
    }

    @Test
    void testEquals() {
        Coordinate coord1 = new Coordinate(1, 2);
        Coordinate coord2 = new Coordinate(1, 2);
        Coordinate coord3 = new Coordinate(3, 4);

        assertTrue(coord1.equals(coord2));
        assertFalse(coord1.equals(coord3));
    }

    @Test
    void testToString() {
        Coordinate coord = new Coordinate(1, 2);

        assertEquals("Coordinate [row=1, column=2]", coord.toString());
    }
}   


    class SOSGridTest {

    @Test
    void testMousePressed() {
        Board board = new Board(new GameSetup());
        GameSetup game = new GameSetup();
        SOSGrid sosGrid = new SOSGrid(board, game);

    }

    @Test
    void testGetCurrentPlayerChoice() {
        Board board = new Board(new GameSetup());
        GameSetup game = new GameSetup();
        SOSGrid sosGrid = new SOSGrid(board, game);

    
    }
    }

    class SOSLineTest {

        @Test
        void testGetLineColor() {
            Color lineColor = Color.RED;
            Coordinate startCoordinate = new Coordinate(1, 2);
            Coordinate endCoordinate = new Coordinate(3, 4);
    
            SOSLine sosLine = new SOSLine(lineColor, startCoordinate, endCoordinate);
    
            assertEquals(lineColor, sosLine.getLineColor());
        }
    
        @Test
        void testGetStartCoordinate() {
            Color lineColor = Color.RED;
            Coordinate startCoordinate = new Coordinate(1, 2);
            Coordinate endCoordinate = new Coordinate(3, 4);
    
            SOSLine sosLine = new SOSLine(lineColor, startCoordinate, endCoordinate);
    
            assertEquals(startCoordinate, sosLine.getStartCoordinate());
        }
    
        @Test
        void testGetEndCoordinate() {
            Color lineColor = Color.RED;
            Coordinate startCoordinate = new Coordinate(1, 2);
            Coordinate endCoordinate = new Coordinate(3, 4);
    
            SOSLine sosLine = new SOSLine(lineColor, startCoordinate, endCoordinate);
    
            assertEquals(endCoordinate, sosLine.getEndCoordinate());
        }
    
        @Test
        void testToString() {
            Color lineColor = Color.RED;
            Coordinate startCoordinate = new Coordinate(1, 2);
            Coordinate endCoordinate = new Coordinate(3, 4);
    
            SOSLine sosLine = new SOSLine(lineColor, startCoordinate, endCoordinate);
    
            String expectedToString = "LineSegment [lineColor=java.awt.Color[r=255,g=0,b=0], " +
                    "startCoordinate=Coordinate [row=1, column=2], endCoordinate=Coordinate [row=3, column=4]]";
    
            assertEquals(expectedToString, sosLine.toString());
        }
        }
    }