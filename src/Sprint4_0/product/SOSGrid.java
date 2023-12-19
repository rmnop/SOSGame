package Sprint4_0.product;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SOSGrid extends MouseAdapter {
    private static char currentPlayerChoice;
    private final Board board;
    private final GameSetup game;
    private int totalSOS;
    
    public SOSGrid(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        SOSGrid.currentPlayerChoice = 'S'; // Initialize to a default value

    }

    public static void setCurrentPlayerChoice(char choice) {
        currentPlayerChoice = choice;
    }


    
    
    @Override
    public void mousePressed(MouseEvent event) {
        Point point = event.getPoint();
        int gameboardWidth = game.getGameboardSize();
        int gridWidth = board.getGridWidth();
        int margin = board.getMargin();
        int row = (point.y - margin) / gridWidth;
        int column = (point.x - margin) / gridWidth;
        
            
        // CHECKING THAT MOUSE CLICK IS WITHIN GAME GRID
        if ((point.y - margin) < 0) {
            return; } 
        if ((point.x - margin) < 0) {
            return; }
        if (row > (gameboardWidth - 1)) {
            return; }
        if (column > (gameboardWidth - 1)) {
            return; }
        
        // MAKING A MOVE - GIVEN OPTION TO PLAY S OR O
        String[] options = { "S", "O" };
        totalSOS = game.lineSegments.size();
       if(game.getGameboard(row, column) == ' ') {
            if(currentPlayerChoice == 'S') {
                game.setGameboard(row, column, options[0]);
                if (game.checkSOS() && totalSOS < game.lineSegments.size()) {
                    totalSOS = game.lineSegments.size();
                    //board.updateScore();
                    board.updateStatusLabel();
                } else {
                    game.nextPlayersTurn();
                    board.updateStatusLabel();
                }
            } else if(currentPlayerChoice == 'O') {
                game.setGameboard(row, column, options[1]);
                if (game.checkSOS() && totalSOS < game.lineSegments.size()) {
                    totalSOS = game.lineSegments.size();
                    board.updateStatusLabel();
                } else {
                    game.nextPlayersTurn();
                    board.updateStatusLabel();
                } 
            } 
            //gameRecorder.recordGame("/Users/samuelcabrera/Desktop/java/SOS/SOS/src/Sprint4_0/product/game.txt", game.getLineSegments());
            board.repaint();
            newGame();          
        } 
    }


    
    // POP ON GAME OVER
    private void newGame() {
        if (game.isGameOver()) {
            int result = JOptionPane.showConfirmDialog(board.getFrame(),
                    "Play Again?", "GAME OVER!",
                    JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.YES_OPTION) {
                totalSOS = 0;
                game.setGameboardSize(game.getGameboardSize()); 
                board.updateStatusLabel();
                //board.updateScore();
                board.repaint();
            } else {
                if (game.isGameOver()) {
                    // ... (existing code)
                    game.saveGameStateToFile("/Users/samuelcabrera/Desktop/java/SOS/SOS/src/Sprint4_0/product/sos.txt"); // Save the game state to a file
                }
                board.shutdown();
            }
        }   
    }
}