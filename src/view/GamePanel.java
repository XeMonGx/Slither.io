package view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;

public class GamePanel extends JPanel {

  private Image backgroundImage;
  private int x;
  private int y;
  private int radius;
  private Color color;

  public GamePanel(int x, int y, int radius, Color color) {
    // Charger l'image depuis les ressources
    backgroundImage = new ImageIcon(getClass().getResource("../resources/background.jpeg")).getImage();
    this.x = x;
    this.y = y;
    this.radius = radius;
    this.color = color;
  }

  // Redéfinir paintComponent pour dessiner l'image
  @Override
  protected void paintComponent(Graphics g) {

    super.paintComponent(g);

    int pictureWidth = backgroundImage.getWidth(this);
    int pictureHeight = backgroundImage.getHeight(this);

    // Dessiner l'image sur tout le JPanel
    for (int x = 0; x < 2; x++) {
      for (int y = 0; y < 2; y++) {
        g.drawImage(backgroundImage, x * pictureWidth, y * pictureHeight, pictureWidth, pictureHeight, this);
      }
    }

    g.setColor(color);
    g.fillOval(x - radius, y - radius, 2 * radius, 2 * radius); // Dessine un cercle centré sur (x, y)
  }

}
