package Sprint1_0.product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SOSGrid extends MouseAdapter {
    private final Board board;
    private final GameSetup game;
    private static char currentPlayerChoice; // Store the current player's choice
    private int totalSOS;
    private BottomPanel turn;
    
    public SOSGrid(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        SOSGrid.currentPlayerChoice = 'S'; // Initialize to a default value

    }

    public static void setCurrentPlayerChoice(char choice) {
        currentPlayerChoice = choice;
        //turn.setDefaultPlayerTurn();
    }

    @Override
    public void mousePressed(MouseEvent event) {
        Point point = event.getPoint();
        int gameboardWidth = game.getGameBoardSize();
        
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
        //totalSOS = game.lineSegments.size();
       /*if (game.getGameboard(row, column) == ' ' && currentPlayerChoice == 'S') {
                game.setGameboard(row, column, options[0]);
                //game.nextPlayersTurn();
            } else if(game.getGameboard(row, column) == ' ' && currentPlayerChoice == 'O') {
                game.setGameboard(row, column, options[1]);
                //game.nextPlayersTurn();
            } 
             // CHECKING FOR AN SOS AFTER EACH MOVE
                if (game.checkSOS() && totalSOS < game.lineSegments.size()) {
                    totalSOS = game.lineSegments.size();
                    //board.updateScore();
                }
            else { 
                game.nextPlayersTurn();
            }
        board.repaint();
        newGame();
    }*/
        if(game.getGameboard(row, column) == ' ') {
            if(currentPlayerChoice == 'S') {
                game.setGameboard(row, column, options[0]);
            } else if(currentPlayerChoice == 'O') {
                game.setGameboard(row, column, options[1]);
                    //board.updateScore();
                    } else {
                        game.nextPlayersTurn();
                    } 
                     board.repaint();
                }
            }
        }