package Sprint1_0.product;
import java.awt.*;
import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel {
        private final Board board;
        private final GameSetup game;
        private final JPanel panel;
        private JLabel userTurn;
        private JLabel turn;
        private int currentPlayer;
        
    public BottomPanel(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        this.panel = userTurn();     
        currentPlayer = 1;     
    }

    private JPanel userTurn() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 5, 5, 5);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;

        userTurn = new JLabel("Current turn: ");
        panel.add(userTurn, c); 
        c.gridx++;
        turn = new JLabel("Blue");
        panel.add(turn, c);   

        c.gridx++;
        JButton switchTurnButton = new JButton("Switch Turn");
        panel.add(switchTurnButton, c);

        // Add action listener to the button
        switchTurnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switchTurn();
                }
            });

        return panel;  
    }

    private void switchTurn() {
        // Switch the turn between Player 1 and Player 2
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
        if(currentPlayer == 1) {
            turn.setText("Blue");
        } else {
            turn.setText("Red");
        }
    }
    

    public JPanel getPanel() {
        return panel;
    }

}
