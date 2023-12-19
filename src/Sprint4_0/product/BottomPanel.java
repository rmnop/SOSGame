package Sprint4_0.product;
import java.awt.*;
import javax.swing.*;

public class BottomPanel {
        private final Board board;
        private final GameSetup game;
        private final JPanel panel;
        private JLabel userTurn;
        private JLabel statusLabel;
        
    public BottomPanel(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        this.panel = userTurn();        
    }

    private JPanel userTurn() {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 5, 10, 5));
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 5, 5, 5);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;

        userTurn = new JLabel("Current turn: ");
        panel.add(userTurn, c);  

        c.gridx++;
        panel.add(Box.createHorizontalGlue(), c);

       
        c.gridx++;
        // GAME STATUS
        statusLabel = new JLabel();        
        panel.add(statusLabel, c);
        updateStatusLabel();
    
        return panel;  
    }


     // METHOD TO UPDATE PLAYER TURN LABEL TEXT
     public void updateStatusLabel() {
        if (game.isGameOver() == true) {
            int[] score = game.getScore();
            if (score[0] > score[1]) {
                statusLabel.setText("Blue Wins!");
            } else if (score[1] > score[0]) {
                statusLabel.setText("Red Wins!");
            } else if (score[0] == score[1]) {
                statusLabel.setText("Draw!");
            }
      
        } else if (game.getPlayerTurn() == 1) {
            statusLabel.setText("Blue");
        } else if (game.getPlayerTurn() == 2) {
            statusLabel.setText("Red");
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
