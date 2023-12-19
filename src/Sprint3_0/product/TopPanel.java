package Sprint3_0.product;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TopPanel {
    private final Board board;
    private final GameSetup game;
    private final JPanel panel;
    private JButton createBoard;
    private JTextField boardSize;

    public TopPanel(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        this.panel = gameStart();
    }


    private JPanel gameStart() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));

        // game type
        JRadioButton simpleGame = new JRadioButton("Simple");
        simpleGame.setSelected(true);
        JRadioButton generalGame = new JRadioButton("General");

        //button group allows only one button to be clicked e.x simple and general can't both be clicked
        ButtonGroup modeButtons = new ButtonGroup();
        modeButtons.add(simpleGame);
        modeButtons.add(generalGame);

        panel.add(simpleGame);
        panel.add(generalGame);
         
        // create board size with spinner button that implements an easier interactin with user
        JLabel boardSizeLabel = new JLabel("Board Size:");
        panel.add(boardSizeLabel);
        
        //int maximum = game.getMaxSize();
        boardSize = new JTextField(2);
        createBoard = new JButton("New Game");
        panel.add(boardSize);
        panel.add(createBoard);

        createBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
            int gameboardSize = Integer.parseInt(boardSize.getText());;
            game.setGameboardSize(gameboardSize);
            board.calculateCells();
            if(gameboardSize < 3 || gameboardSize > 10) {
                throw new IllegalArgumentException("Limit can not be < 10");
            } 
            
            if (simpleGame.isSelected())
                game.setGameMode(0);
            if (generalGame.isSelected())
                game.setGameMode(1);
            board.repaint();
                throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
            }
            
        });

        return panel;
    }
    
    // getter
    public JPanel getPanel() {
        return panel;
    }
}

