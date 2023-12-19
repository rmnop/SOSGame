package Sprint3_0.product;
/*import java.awt.Color;
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
     public List<SOSLine> lineSegments;
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
         this.lineSegments = new ArrayList<>();
         this.score = new int[2];

         currentPlayer = 'S';
     }

     //setter for gameboard size
     public void setGameboardSize(int gameBoardSize) {
        this.gameBoardSize = gameBoardSize;
        this.gameBoard = initializeBoard(gameBoardSize);
        this.lineSegments.clear();
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


    //check if game is over
    public boolean isGameOver() {
        while (gameMode == 0 && isSimpleGameOver() == true) {
            return true; 
            }
        while (gameMode == 1 && isGeneralGameOver() == true) {
            return true;
            }
        return false;
    }

    // simple game setup if full
    public boolean isSimpleGameOver() {
    if (checkSOS() == true) {
        return true; 
    } else {
    for (int row = 0; row < gameBoardSize; row++) {
        for (int column = 0; column < gameBoardSize; column++) {
            if (gameBoard[row][column] == ' ') {
                return false;
                }
            }
            }
            return true;
        }
    }

       // general game setup if full
       public boolean isGeneralGameOver() {
        for (int row = 0; row < gameBoardSize; row++) {
            for (int column = 0; column < gameBoardSize; column++) {
                if (gameBoard[row][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

   //veryfiing sos
   public boolean checkSOS() {
    boolean sosFound = false;
    for (int row = 0; row < gameBoardSize; row++) {
        for (int column = 0; column < gameBoardSize; column++) {
            if (checkHorizontal(row, column)) sosFound = true;
            if (checkDiagonalLR(row, column)) sosFound = true;
            if (checkVertical(row, column)) sosFound = true;
            if (checkDiagonalRL(row, column)) sosFound = true;
        }
    }
    return sosFound;
}

// sos horizontally
public boolean checkHorizontal(int row, int column) {
    Color[] lineColor = { Color.BLUE, Color.RED };
    //Color[] playerColors = { Color.BLUE, Color.RED };
    if (isCharacter('S', row, column)
            && isCharacter('O', row, column + 1)
            && isCharacter('S', row, column + 2)) {
        Coordinate start = new Coordinate(row, column);
        Coordinate end = new Coordinate(row, column + 2);
        Color color = lineColor[playerTurn - 1];
        if (addLineSegment(new SOSLine(color, start, end))) {
            incrementScore(playerTurn);
        }
        return true;
    } else {
        return false;
    }
}


// sos vertically
private boolean checkVertical(int row, int column) {
    Color[] lineColor = { Color.BLUE, Color.RED };
     //Color[] playerColors = { Color.BLUE, Color.RED };
    if (isCharacter('S', row, column)
            && isCharacter('O', row + 1, column)
            && isCharacter('S', row + 2, column)) {
        Coordinate start = new Coordinate(row, column);
        Coordinate end = new Coordinate(row + 2, column);
        Color color = lineColor[playerTurn - 1];
        if (addLineSegment(new SOSLine(color, start, end))) {
            incrementScore(playerTurn);
        }
        return true;
    } else {
        return false;
    }
}

// sos vertically
private boolean checkDiagonalLR(int row, int column) {
    Color[] lineColor = { Color.BLUE, Color.RED };
    // Color[] playerColors = { Color.BLUE, Color.RED };
    if (isCharacter('S', row, column)
            && isCharacter('O', row + 1, column + 1)
            && isCharacter('S', row + 2, column + 2)) {
        Coordinate start = new Coordinate(row, column);
        Coordinate end = new Coordinate(row + 2, column + 2);
        Color color = lineColor[playerTurn - 1];
        if (addLineSegment(new SOSLine(color, start, end))) {
            incrementScore(playerTurn);
        }
        return true;
    } else {
        return false;
    }
}

// sos diagonally
private boolean checkDiagonalRL(int row, int column) {
    Color[] lineColor = { Color.BLUE, Color.RED };
    if (isCharacter('S', row, column)
            && isCharacter('O', row + 1, column - 1)
            && isCharacter('S', row + 2, column - 2)) {
        Coordinate start = new Coordinate(row, column);
        Coordinate end = new Coordinate(row + 2, column - 2);
        Color color = lineColor[playerTurn - 1];
        if (addLineSegment(new SOSLine(color, start, end))) {
           incrementScore(playerTurn);
        }
        return true;
    } else {
        return false;
    }
}


// if there is sos already in
 private boolean isCharacter(char c, int row, int column) {
    if (row < 0 || row > (gameBoardSize - 1)) {
        return false; }
    
    if (column < 0 || column > (gameBoardSize - 1)) {
        return false; }
    
    if (gameBoard[row][column] == c) {
        return true;
    } else {
        return false; }
}
  

    private boolean addLineSegment(SOSLine lineSegment) {
        SOSLine newSegment = new SOSLine(lineSegment.getLineColor(),
                lineSegment.getEndCoordinate(), lineSegment.getStartCoordinate());
        if (SOSLine(lineSegment) || SOSLine(newSegment)) {
            return false;
        } else {
            lineSegments.add(lineSegment);
            return true; 
            }
    }

    private boolean SOSLine(SOSLine lineSegment) {
        return false;
    }

    public List<SOSLine> getLineSegments() {
        return lineSegments; }

    
    private void incrementScore(int player) {
        this.score[player - 1]++; }

    public int[] getScore() {
        return score; }
    }
    */
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameSetup {
    private final int minimumSize, defaultSize, maximumSize;
    private int gameboardSize, playerTurn;
    private int[] score;
    private char[][] gameboard;
    public int gameMode;
    private char currentPlayer;
    
    // FOR COMPUTER AUTO PLAY
    public int bluePlayer;
    public int redPlayer;

    public List<SOSLine> lineSegments;
    
    public GameSetup() {
        this.minimumSize = 3;
        this.defaultSize = 3;
        this.maximumSize = 10;
        this.gameboardSize = defaultSize;
        this.gameboard = initializeGameboard(gameboardSize);
        this.lineSegments = new ArrayList<>();
        this.playerTurn = 1;
        this.score = new int[2];

        currentPlayer = 'S';

    }
    
    public int setGameMode(int gameMode) {
        this.gameMode = gameMode;
        return gameMode; }

    public int getGameboardSize() {
        return gameboardSize; }
    
    public void setGameboardSize(int gameboardSize) {
        this.gameboardSize = gameboardSize;
        this.gameboard = initializeGameboard(gameboardSize);
        this.lineSegments.clear();
        this.playerTurn = 1;
        this.score = new int[2];
    }
    
    private char[][] initializeGameboard(int gameboardWidth) {
        char[][] gameboard = new char[gameboardWidth][gameboardWidth];
        
        for (int row = 0; row < gameboardWidth; row++) {
            for (int column = 0; column < gameboardWidth; column++) {
                gameboard[row][column] = ' ';
            }
        }
        return gameboard;
    }
    
    
    public void setGameboard(int row, int column, String letter) {
        this.gameboard[row][column] = letter.charAt(0); }
    
    public char getGameboard(int row, int column) {
        return gameboard[row][column]; }

    public char[][] getGameboard() {
        return gameboard; }
    
    
    // SIMPLE GAME OVER - AFTER FIRST SOS MADE (OR BOARD IS FULL)
    public boolean isSimpleGameOver() {
        if (checkSOS() == true) {
            return true;
        } else {
            for (int row = 0; row < gameboardSize; row++) {
                for (int column = 0; column < gameboardSize; column++) {
                    if (gameboard[row][column] == ' ') {
                        return false;
                    }
                }
            }
            return true;
        }
    }
    
    
    // GENERAL GAME OVER - CHECKING FOR A FULL BOARD
    public boolean isGeneralGameOver() {
        for (int row = 0; row < gameboardSize; row++) {
            for (int column = 0; column < gameboardSize; column++) {
                if (gameboard[row][column] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    
    // GAME OVER
    public boolean isGameOver() {
        while (gameMode == 0 && isSimpleGameOver() == true) {
            return true; 
            }
        while (gameMode == 1 && isGeneralGameOver() == true) {
            return true;
            }
        return false;
    }
    
    public int getMinimumSize() {
        return minimumSize; }

    public int getDefaultSize() {
        return defaultSize; }

    public int getMaximumSize() {
        return maximumSize; }
    
    public void nextPlayersTurn() {
        this.playerTurn = (playerTurn == 1) ? 2 : 1; }

    public int getPlayerTurn() {
        return playerTurn; }
    
    
    // CHECKING GRID FOR SOS
    public boolean checkSOS() {
        boolean sosFound = false;
        for (int row = 0; row < gameboardSize; row++) {
            for (int column = 0; column < gameboardSize; column++) {
                if (checkHorizontal(row, column)) sosFound = true;
                if (checkDiagonalLR(row, column)) sosFound = true;
                if (checkVertical(row, column)) sosFound = true;
                if (checkDiagonalRL(row, column)) sosFound = true;
            }
        }
        return sosFound;
    }
    
    // CHECKING FOR SOS HORIZONTALLY
    public boolean checkHorizontal(int row, int column) {
        Color[] lineColor = { Color.BLUE, Color.RED };
        if (isCharacter('S', row, column)
                && isCharacter('O', row, column + 1)
                && isCharacter('S', row, column + 2)) {
            Coordinate start = new Coordinate(row, column);
            Coordinate end = new Coordinate(row, column + 2);
            Color color = lineColor[playerTurn - 1];
            if (addLineSegment(new SOSLine(color, start, end))) {
                incrementScore(playerTurn);
            }
            return true;
        } else {
            return false;
        }
    }
    
    // CHECKING FOR SOS VERTICALLY
    private boolean checkVertical(int row, int column) {
        Color[] lineColor = { Color.BLUE, Color.RED };
        if (isCharacter('S', row, column)
                && isCharacter('O', row + 1, column)
                && isCharacter('S', row + 2, column)) {
            Coordinate start = new Coordinate(row, column);
            Coordinate end = new Coordinate(row + 2, column);
            Color color = lineColor[playerTurn - 1];
            if (addLineSegment(new SOSLine(color, start, end))) {
                incrementScore(playerTurn);
            }
            return true;
        } else {
            return false;
        }
    }
    
    // CHECKING FOR SOS DIAGONALLY (LEFT TO RIGHT)
    private boolean checkDiagonalLR(int row, int column) {
        Color[] lineColor = { Color.BLUE, Color.RED };
        if (isCharacter('S', row, column)
                && isCharacter('O', row + 1, column + 1)
                && isCharacter('S', row + 2, column + 2)) {
            Coordinate start = new Coordinate(row, column);
            Coordinate end = new Coordinate(row + 2, column + 2);
            Color color = lineColor[playerTurn - 1];
            if (addLineSegment(new SOSLine(color, start, end))) {
                incrementScore(playerTurn);
            }
            return true;
        } else {
            return false;
        }
    }
    
    // CHECKING FOR SOS DIAGONALLY (RIGHT TO LEFT)
    private boolean checkDiagonalRL(int row, int column) {
        Color[] lineColor = { Color.BLUE, Color.RED };
        if (isCharacter('S', row, column)
                && isCharacter('O', row + 1, column - 1)
                && isCharacter('S', row + 2, column - 2)) {
            Coordinate start = new Coordinate(row, column);
            Coordinate end = new Coordinate(row + 2, column - 2);
            Color color = lineColor[playerTurn - 1];
            if (addLineSegment(new SOSLine(color, start, end))) {
                incrementScore(playerTurn);
            }
            return true;
        } else {
            return false;
        }
    }
    
    // METHOD CHECKING IF CELL ALREADY HAS A LETTER PLAYED IN IT
    private boolean isCharacter(char c, int row, int column) {
        if (row < 0 || row > (gameboardSize - 1)) {
            return false; }
        
        if (column < 0 || column > (gameboardSize - 1)) {
            return false; }
        
        if (gameboard[row][column] == c) {
            return true;
        } else {
            return false; }
    }
        
    private boolean addLineSegment(SOSLine lineSegment) {
        SOSLine newSegment = new SOSLine(lineSegment.getLineColor(),
                lineSegment.getEndCoordinate(), lineSegment.getStartCoordinate());
        if (checkLineCoordinates(lineSegment) || checkLineCoordinates(newSegment)) {
            return false;
        } else {
            lineSegments.add(lineSegment);
            return true; 
            }
    }
    
    private boolean checkLineCoordinates(SOSLine lineSegment) {
        for (SOSLine segment : lineSegments) {
            if ((segment.getStartCoordinate()
                    .equals(lineSegment.getStartCoordinate()))
                    && (segment.getEndCoordinate()
                            .equals(lineSegment.getEndCoordinate()))) {
                return true;
            }
        }
        return false;
    }

    public List<SOSLine> getLineSegments() {
        return lineSegments; }
    
    private void incrementScore(int player) {
        this.score[player - 1]++; }

    public int[] getScore() {
        return score; }

    public void playComputerMove() {
    }

    public void setGameboard(char[][] mockGameboard) {
    }
   
}
