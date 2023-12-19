package Sprint1_0.product;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RightPanel {
    private final Board board;
    private final GameSetup game;
    private final JPanel panel;
    private JLabel Player;
    public char player2Choice1;
    public char player2Choice2;
    private final GameSetup playerTurn;

    public RightPanel(Board board, GameSetup game, GameSetup playerTurn) {
        this.board = board;
        this.game = game;
        this.panel = redPlayer();
        this.playerTurn = playerTurn;
    }

    private JPanel redPlayer() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 5));
        GridBagConstraints c = new GridBagConstraints();

        c.insets = new Insets(0, 5, 5, 5);
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        
        Player = new JLabel("RedPlayer");
        panel.add(Player, c);

        //incrementing gridy expands the y to make a spot for S and O
        c.gridy++;
        JRadioButton S = new JRadioButton("S");
        S.setSelected(true);
        panel.add(S, c);
        
        c.gridy++;
        JRadioButton O = new JRadioButton("O");
        panel.add(O, c);

        ButtonGroup turnButtons = new ButtonGroup();
        turnButtons.add(S);
        turnButtons.add(O);

        S.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2Choice1 = 'S';
                SOSGrid.setCurrentPlayerChoice(player2Choice1);

            }
        });
        
        O.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                player2Choice2 = 'O';
                SOSGrid.setCurrentPlayerChoice(player2Choice2);
            }
        });

        return panel;
    }

    public JPanel getPanel() {
        return panel;
    }
}
