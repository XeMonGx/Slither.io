package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class ViewSnake extends JPanel {
  private int x;
  private int y;
  private int radius;
  private Color color;

  // Constructeur pour initialiser les paramètres du cercle
  public ViewSnake(int x, int y, int radius, Color color) {
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = color;
  }

  // Méthode pour dessiner le cercle
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.setColor(color);
    g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius); // Dessine un cercle centré sur (x, y)
  }
}
