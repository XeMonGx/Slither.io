package model;

import controller.Direction;

public class SnakeBody implements SnakeSegment {

  private int x;
  private int y;
  private Effect effect;
  private SnakeSegment preSegment;
  private int space;

  public SnakeBody(SnakeSegment preSegment, int x, int y, int space) {
    this.preSegment = preSegment;
    this.space = space;
    this.x = x;
    this.y = y;
  }

  @Override
  public void move() {
    int directionX = preSegment.getX() - this.x;
    int directionY = preSegment.getY() - this.y;
    int length = (int) Math.sqrt(directionX * directionX + directionY * directionY);
    if (length > space) {
      this.x = preSegment.getX() - directionX * space / length;
      this.y = preSegment.getY() - directionY * space / length;
    }
  }

  @Override
  public int getX() {
    return this.x;
  }

  @Override
  public int getY() {
    return this.y;
  }

}
