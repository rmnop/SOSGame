package Sprint4_0.product;

import java.awt.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


    public class GameSetup {
        private final int minimumSize, defaultSize, maximumSize;
        private int gameboardSize, playerTurn;
        private int[] score;
        private char[][] gameboard;
        public int gameMode;
        private char currentPlayer;
        public int playerMode;
        
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

    public int setPlayerType(int playerMode) {
        this.playerMode = playerMode;
        return playerMode;
    }

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

    
        public void playComputerMove() {
            
            // Add your logic to generate a random move for the computer player (bluePlayer)
            Random random = new Random();
            int row, column;
                do {
                    row = random.nextInt(gameboardSize);
                    column = random.nextInt(gameboardSize);
                } while (getGameboard(row, column) != ' '); // Keep generating until an empty cell is found
    
                // Randomly choose between 'S' and 'O'
                String letterToPlace = (random.nextBoolean()) ? "S" : "O";
                setGameboard(row, column, letterToPlace);     
        }

     

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
    private boolean checkHorizontal(int row, int column) {
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
        } 
        else {
            lineSegments.add(lineSegment);
        return true; 
        }
    }
    
    private boolean checkLineCoordinates(SOSLine lineSegment) {
        for (SOSLine segment : lineSegments) {
            if ((segment.getStartCoordinate().equals(lineSegment.getStartCoordinate())) && (segment.getEndCoordinate().equals(lineSegment.getEndCoordinate()))) {
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

         // NEW METHOD: Generate a string representation of the game state
    public String generateGameStateString() {
        StringBuilder gameState = new StringBuilder();

        char[][] gameboard = getGameboard();
        // Append the top border of the board
        for (int i = 0; i < gameboard.length * 4 + 1; i++) {
            gameState.append("-");
        }
        gameState.append("\n");

        for (int row = 0; row < gameboard.length; row++) {
            gameState.append("|"); // Left border {
            for (int column = 0; column < gameboard[row].length; column++) {
                gameState.append(" " + gameboard[row][column]).append(" |");
            }
                gameState.append("\n");
                for (int i = 0; i < gameboard.length * 4 + 1; i++) {
                    gameState.append("-");
                }
                gameState.append("\n");
        }

        // Append the scores
        int[] scores = getScore();
        gameState.append("Score: Player 1 - ").append(scores[0]).append(", Player 2 - ").append(scores[1]);

        return gameState.toString();
    
}


    // NEW METHOD: Save the game state to a text file
    public void saveGameStateToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            String gameStateString = generateGameStateString();
            writer.write(gameStateString);
            System.out.println("Game state saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
