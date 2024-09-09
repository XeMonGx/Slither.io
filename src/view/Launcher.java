package view;

import javax.swing.JFrame;

import controller.KeyboardController;
import model.Map;

public class Launcher extends JFrame {

    public Launcher() {
        // Configuration de la fenêtre
        setTitle("Launcher");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        Map map = new Map(100, 100);

        // Ajout du panneau de jeu
        GamePanel gamePanel = new GamePanel(1280, 720, map);
        add(gamePanel);
    }
}
