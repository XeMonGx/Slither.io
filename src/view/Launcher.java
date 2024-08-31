package view;

import javax.swing.JFrame;

public class Launcher extends JFrame {

    public Launcher() {
        // Configuration de la fenêtre
        setTitle("Launcher");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        ViewMap viewMap = new ViewMap();
        add(viewMap);
        ViewSnake viewSnake = new ViewSnake(100, 100, 50, java.awt.Color.RED);
        add(viewSnake);
    }
}
