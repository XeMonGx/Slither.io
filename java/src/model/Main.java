package model;

import view.Launcher;

import javax.swing.SwingUtilities;

public class Main {
  public static void main(String[] args) {
    // Création de la fenêtre dans le thread de l'interface utilisateur
    SwingUtilities.invokeLater(() -> {
      Launcher launcher = new Launcher();
      launcher.setVisible(true);
    });
  }
}
