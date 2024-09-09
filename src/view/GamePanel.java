package view;

import controller.KeyboardController;
import controller.MouseController;
import model.Map;
import model.Snake;

import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

  private Map map;
  private Snake meSnake;
  private KeyboardController keyboardController;
  private MouseController mouseController;
  private Thread gameThread;
  private boolean running = false;
  private final int FPS = 60;
  private final long targetTime = 1000 / FPS;

  public GamePanel(Map map) {

    setFocusable(true);
    requestFocus();
    // add key listener
    this.keyboardController = new KeyboardController();
    this.addKeyListener(keyboardController);
    // add mouse listener
    this.mouseController = new MouseController();
    this.addMouseMotionListener(mouseController);
    // set map
    this.map = map;
    // create a new snake
    this.meSnake = new Snake(keyboardController, null);
    // add snake to map
    this.map.addSnake(meSnake);
    // start the game
    start();
  }

  private void start() {
    running = true;
    gameThread = new Thread(this);
    gameThread.start();
  }

  private void stop() {
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

    while (running) { // game loop
      startTime = System.nanoTime();

      update(); // update game logic
      repaint(); // repaint the game

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

  private void update() {
    map.update();
    meSnake.update();
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Draw.drawMap(g, this);
    Draw.drawFoods(g, map.getFoods());
    Draw.drawSnakes(g, map.getSnakes());
    Draw.drawExpPorcentage(g, meSnake, this.getWidth() / 2 - 50, this.getHeight() - 25);
  }

}
