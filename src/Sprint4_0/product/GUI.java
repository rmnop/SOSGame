package Sprint4_0.product;

import javax.swing.*;

public class GUI implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new GUI() {
        });
        }

    @Override
    public void run() {
        new Board(new GameSetup());
    }
}