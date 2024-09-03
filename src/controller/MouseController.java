package controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseController implements MouseMotionListener {

  private int x;
  private int y;

  @Override
  public void mouseDragged(MouseEvent e) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'mouseDragged'");
  }

  @Override
  public void mouseMoved(MouseEvent e) {
    this.x = e.getX();
    this.y = e.getY();
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

}
