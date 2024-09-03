package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

  private Direction direction;

  public KeyboardController() {
    this.direction = Direction.RIGHT;
  }

  @Override
  public void keyTyped(KeyEvent e) {

  }

  @Override
  public void keyPressed(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_W:
        this.direction = Direction.UP;
        break;
      case KeyEvent.VK_S:
        this.direction = Direction.DOWN;
        break;
      case KeyEvent.VK_A:
        this.direction = Direction.LEFT;
        break;
      case KeyEvent.VK_D:
        this.direction = Direction.RIGHT;
        break;
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  public Direction getDirection() {
    return direction;
  }

}
