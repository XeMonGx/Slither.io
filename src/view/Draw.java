package view;

import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Color;

import model.Camera;
import model.Food;
import model.Snake;

public class Draw {

  private static Image backgroundImage = new ImageIcon(Draw.class.getResource("../resources/background.jpeg"))
      .getImage();

  public static void drawMap(Graphics g, JPanel panel, Camera camera) {
    int pictureWidth = backgroundImage.getWidth(panel);
    int pictureHeight = backgroundImage.getHeight(panel);

    // Dessiner l'image sur tout le JPanel
    for (int x = -3; x < 3; x++) {
      for (int y = -3; y < 3; y++) {
        g.drawImage(backgroundImage, pictureWidth * x - camera.getX(), pictureHeight * y - camera.getY(), pictureWidth,
            pictureHeight, panel);
      }
    }
  }

  public static void drawFoods(Graphics g, ArrayList<Food> foods, Camera camera) {
    for (Food food : foods) {
      g.setColor(food.getColor());
      g.fillOval(food.getX() - camera.getX() - food.getSize(), food.getY() - camera.getY() - food.getSize(),
          2 * food.getSize(), 2 * food.getSize());
    }
  }

  public static void drawSnakes(Graphics g, ArrayList<Snake> snakes, Camera camera) {
    for (Snake snake : snakes) {
      for (int i = 0; i < snake.getSegments().size(); i++) {
        g.setColor(snake.getColor());
        g.fillOval(
            snake.getSegments().get(i).getX() - camera.getX() - snake.getSize(),
            snake.getSegments().get(i).getY() - camera.getY() - snake.getSize(),
            snake.getSize() * 2,
            snake.getSize() * 2);
      }
    }
  }

  public static void drawExpPorcentage(Graphics g, Snake snake, int width, int height) {
    int expsize = (int) (100 * snake.getExp() / snake.getMaxExp());
    g.setColor(Color.WHITE);
    g.fillRect(width, height, 100, 15);
    g.setColor(Color.BLACK);
    g.fillRect(width + 1, height + 1, expsize, 13);
  }

}
