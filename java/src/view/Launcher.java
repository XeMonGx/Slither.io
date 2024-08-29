package view;

import java.awt.Color;
import javax.swing.JFrame;

public class Launcher extends JFrame {

    public ViewSnake snake;

    public Launcher() {
        // Configuration de la fenêtre
        setTitle("Launcher");
        setSize(1280, 720);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        this.snake = new ViewSnake(10, 10, 10, Color.BLACK);
        this.add(this.snake);
        snake.paintComponent(this.getGraphics());

    }
}
