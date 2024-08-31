package view;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class ViewMap extends JPanel {

  private Image backgroundImage;

  // Constructeur qui charge l'image
  public ViewMap() {
    // Charger l'image depuis les ressources
    backgroundImage = new ImageIcon(getClass().getResource("../resources/background.jpeg")).getImage();
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
  }

}
