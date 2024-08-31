package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

  Direction direction;

  @Override
  public void keyTyped(KeyEvent e) {
    switch (e.getKeyCode()) {
      case KeyEvent.VK_UP:
        direction = Direction.UP;
        break;
      case KeyEvent.VK_DOWN:
        direction = Direction.DOWN;
        break;
      case KeyEvent.VK_LEFT:
        direction = Direction.LEFT;
        break;
      case KeyEvent.VK_RIGHT:
        direction = Direction.RIGHT;
        break;
    }
  }

  @Override
  public void keyPressed(KeyEvent e) {

  }

  @Override
  public void keyReleased(KeyEvent e) {

  }

  public Direction getDirection() {
    return direction;
  }

}
