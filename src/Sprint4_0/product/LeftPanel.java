package Sprint4_0.product;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class LeftPanel {
    private final Board board;
    private final GameSetup game;
    private final JPanel panel;
    private JLabel Player1;
    public char player1Choice1;
    public char player1Choice2;
    public char aiChoice;
    private int totalSOS;

    private JRadioButton computerBluePlayer;
    private JRadioButton human;
    private JButton computerPlay;

    public LeftPanel(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        this.panel = bluePlayer();
        
    }

    private JPanel bluePlayer() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        GridBagConstraints c = new GridBagConstraints();


        c.insets = new Insets(0, 5, 5, 5);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        
        Player1 = new JLabel("BluePlayer");
        panel.add(Player1, c);

        //incrementing gridy expands the y to make a spot for S and O
        c.gridy++;
        human = new JRadioButton("Human");
        panel.add(human, c);
        human.setSelected(true);
        c.gridy++;
        JRadioButton buttonS = new JRadioButton("S");
        buttonS.setSelected(true);
        panel.add(buttonS, c);

        c.gridy++;
        JRadioButton buttonO = new JRadioButton("O");
        panel.add(buttonO, c);

        ButtonGroup turnButtons = new ButtonGroup();
        turnButtons.add(buttonS);
        turnButtons.add(buttonO);  

        player1Choice1 = 'S';
        player1Choice2 = 'O';

        c.gridy++;
        computerBluePlayer = new JRadioButton("Computer");
        panel.add(computerBluePlayer, c);

        c.gridy++;
        computerPlay = new JButton("Computer");
        panel.add(computerPlay, c);
        computerPlay.setVisible(false);


        ButtonGroup humanOrNPC = new ButtonGroup();
        humanOrNPC.add(human);
        humanOrNPC.add(computerBluePlayer);
       

        human.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(human.isSelected()) {
                    game.setPlayerType(0);
                }
            }
        });

        buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                SOSGrid.setCurrentPlayerChoice(player1Choice1);
            }

    
        });
        
        buttonO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SOSGrid.setCurrentPlayerChoice(player1Choice2);
            }
        });

        computerBluePlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.setPlayerType(1);
                totalSOS = game.lineSegments.size();
                if(game.gameMode == 1 || game.gameMode == 0) {
                    game.playComputerMove();
                    if (game.checkSOS() && totalSOS < game.lineSegments.size()) {
                        totalSOS = game.lineSegments.size();
                        board.updateStatusLabel(); 
                    } else {
                        game.nextPlayersTurn();
                        board.updateStatusLabel();
                    } 
                    board.repaint();
                }
                if (game.isGameOver()) {
                int result = JOptionPane.showConfirmDialog(board.getFrame(),
                "Play Again?", "GAME OVER!",
                JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                totalSOS = 0;
            game.setGameboardSize(game.getGameboardSize()); 
            board.updateStatusLabel();
            board.repaint();
        } else {
            if (game.isGameOver()) {
                game.saveGameStateToFile("/Users/samuelcabrera/Desktop/java/SOS/SOS/src/Sprint4_0/product/sos.txt"); // Save the game state to a file
            }
            board.shutdown();
             }
            }
        }
            
        });
        

     return panel;
    
}

    public JPanel getPanel() {
        return panel;
    }
}
