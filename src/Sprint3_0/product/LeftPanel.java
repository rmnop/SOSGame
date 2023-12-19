package Sprint3_0.product;
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
    private final GameSetup playerTurn;

    public LeftPanel(Board board, GameSetup game, GameSetup playerTurn) {
        this.board = board;
        this.game = game;
        this.panel = bluePlayer();
        this.playerTurn = playerTurn;
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

        buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { 
                SOSGrid.setCurrentPlayerChoice(player1Choice1);
                game.getPlayerTurn();
                
                //playerTurn.setPlayerTurn(player1Choice1);
            }

    
        });
        
        buttonO.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               SOSGrid.setCurrentPlayerChoice(player1Choice2);
                //layerTurn.setPlayerTurn(player1Choice2);
            }
        });
        

     return panel;
    
}

    public JPanel getPanel() {
        return panel;
    }
}
