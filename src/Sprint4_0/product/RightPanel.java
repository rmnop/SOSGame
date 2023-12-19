package Sprint4_0.product;
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
    private JRadioButton computerRedPlayer;
    private int totalSOS;

    public RightPanel(Board board, GameSetup game) {
        this.board = board;
        this.game = game;
        this.panel = redPlayer();
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

        c.gridy++;
        JRadioButton human = new JRadioButton("Human");
        panel.add(human,c );
        human.setSelected(true);
        //incrementing gridy expands the y to make a spot for S and O
        c.gridy++;
        JRadioButton S = new JRadioButton("S");
        S.setSelected(true);
        panel.add(S, c);
        
        c.gridy++;
        JRadioButton O = new JRadioButton("O");
        panel.add(O, c);

        c.gridy++;
        computerRedPlayer = new JRadioButton("Computer");
        panel.add(computerRedPlayer, c);

        ButtonGroup turnButtons = new ButtonGroup();
        turnButtons.add(S);
        turnButtons.add(O);

        ButtonGroup humanOrNPC = new ButtonGroup();
        humanOrNPC.add(human);
        humanOrNPC.add(computerRedPlayer);

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

        computerRedPlayer.addActionListener(new ActionListener() {
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
                //board.updateScore();
                board.repaint();
            } else {
                if (game.isGameOver()) {
                    // ... (existing code)
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
