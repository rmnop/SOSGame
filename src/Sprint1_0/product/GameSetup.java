package Sprint1_0.product;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;



public class GameSetup {
     //set board size
     private int gameBoardSize, playerTurn;
     private int gridSize;
     private char[][] gameBoard;
     public int gameMode;
     private final int maxSize, defaultSize, minSize;
     private JLabel userTurn;
     private char currentPlayer;
     private int[] score;
     private JPanel turn;

       public enum CellState {
        EMPTY, BLUE, RED
    }
 

     public GameSetup() {
         this.defaultSize = 3;
         this.maxSize = 10;
         this.minSize = 3;
         this.gameBoardSize = defaultSize;
         this.gameBoard = initializeBoard(gameBoardSize);
         this.playerTurn = 1;
         this.score = new int[2];

         currentPlayer = 'S';
     }

     //setter for gameboard size
     public void setGameboardSize(int gameBoardSize) {
        this.gameBoardSize = gameBoardSize;
        this.gameBoard = initializeBoard(gameBoardSize);
        this.playerTurn = 1;
        this.score = new int[2];

     }

      //setter for game mode type
     public int setGameMode(int gameMode) {
        this.gameMode = gameMode;
        return gameMode;
     }

        //getter for board size after input
    public int getGameBoardSize() {
        return gameBoardSize;
    }


    //initializes gameboard to get each cell.row and cell.col
     public char[][] initializeBoard(int gameboardWidth) {
        char[][] gameboard = new char[gameboardWidth][gameboardWidth];
        
        for (int row = 0; row < gameboardWidth; row++) {
            for (int column = 0; column < gameboardWidth; column++) {
                gameboard[row][column] = ' ';
            }
        }
        return gameboard;
    }

    // Initialize the color grid
private Color[][] initializeGridColors(int gameboardWidth) {
    Color[][] colors = new Color[gameboardWidth][gameboardWidth];
    for (int row = 0; row < gameboardWidth; row++) {
        for (int column = 0; column < gameboardWidth; column++) {
            colors[row][column] = Color.WHITE; // Set initial color to white or any default color
        }
    }
    return colors;
}



       //implements char onto board
    public void setGameboard(int row, int col, String options) {
            this.gameBoard[row][col] = options.charAt(0); 
    }
 
    public char getGameboard(int row, int column) {
        return gameBoard[row][column]; 
    }


    //getters for gameBoard and cells
    public char[][] getGameboard() {
        return gameBoard;
    }


    //getter for maximum size of board
     public int getMaxSize() {
         return maxSize;
     }

     public int getDefaultSize() {
        return defaultSize;
     }

    public void nextPlayersTurn() {
        this.playerTurn = (playerTurn == 1) ? 2: 1; 
    }

    public int getPlayerTurn() {
        return playerTurn;
    }
 

    
    private void incrementScore(int player) {
        this.score[player - 1]++; }

    public int[] getScore() {
        return score; }

 }

