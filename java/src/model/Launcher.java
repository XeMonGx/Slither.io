package model;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Launcher extends JFrame {

    public Launcher() {
        // Configuration de la fenêtre
        setTitle("Launcher");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrer la fenêtre

        // Création d'un panneau
        JPanel panel = new JPanel();
        getContentPane().add(panel);
        
        // Création d'un label
        JLabel label = new JLabel("Cliquez sur le bouton pour lancer.");
        panel.add(label);

        // Création d'un bouton
        JButton launchButton = new JButton("Lancer");
        panel.add(launchButton);

        // Ajout d'un écouteur d'événements pour le bouton
        launchButton.addActionListener(e -> {
            // Action à effectuer lors du clic sur le bouton
            label.setText("Lancement réussi !");
        });
    }

    public static void main(String[] args) {
        // Création de la fenêtre dans le thread de l'interface utilisateur
        SwingUtilities.invokeLater(() -> {
            Launcher launcher = new Launcher();
            launcher.setVisible(true);
        });
    }
}
