package view;

import controller.KeyboardController;
import model.Map;
import model.Snake;

import java.awt.Graphics;
import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

  private Image backgroundImage;
  private Map map;
  private Snake meSnake;
  private KeyboardController keyboardController;
  private Thread gameThread;
  private boolean running = false;
  private final int FPS = 60;
  private final long targetTime = 1000 / FPS;

  public GamePanel(int x, int y, int radius, Color color, Map map) {

    setFocusable(true);
    requestFocus();
    this.keyboardController = new KeyboardController();
    this.addKeyListener(keyboardController);

    backgroundImage = new ImageIcon(getClass().getResource("../resources/background.jpeg")).getImage();
    this.meSnake = new Snake(keyboardController, null);
    this.map = map;
    this.map.addSnake(meSnake);
    start();
  }

  // Démarrer le jeu
  public void start() {
    running = true;
    gameThread = new Thread(this);
    gameThread.start();
  }

  // Arrêter le jeu
  public void stop() {
    running = false;
    try {
      gameThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  @Override
  public void run() {
    long startTime;
    long elapsedTime;
    long waitTime;

    while (running) {
      startTime = System.nanoTime();

      update(); // Mise à jour de la logique du jeu
      repaint(); // Appelle paintComponent pour dessiner le jeu

      elapsedTime = System.nanoTime() - startTime;
      waitTime = targetTime - elapsedTime / 1000000;

      try {
        if (waitTime > 0) {
          Thread.sleep(waitTime);
        }
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

  // Mise à jour de la logique du jeu
  public void update() {
    map.update();
    meSnake.update();
  }

  private void drawMap(Graphics g) {
    int pictureWidth = backgroundImage.getWidth(this);
    int pictureHeight = backgroundImage.getHeight(this);

    // Dessiner l'image sur tout le JPanel
    for (int x = 0; x < 2; x++) {
      for (int y = 0; y < 2; y++) {
        g.drawImage(backgroundImage, x * pictureWidth, y * pictureHeight, pictureWidth, pictureHeight, this);
      }
    }
  }

  private void drawSnake(Graphics g) {
    Snake snake = meSnake;
    for (int i = 0; i < snake.getSegments().size(); i++) {
      g.setColor(Color.GREEN);
      g.fillOval(snake.getSegments().get(i).getX() - snake.getSize(),
          snake.getSegments().get(i).getY() - snake.getSize(), 2 * snake.getSize(), 2 * snake.getSize());
    }
  }

  // Redéfinir paintComponent pour dessiner l'image
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    this.drawMap(g);
    this.drawSnake(g);
  }

}
