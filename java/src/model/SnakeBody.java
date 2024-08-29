package model;

public class SnakeBody implements SnakeSegment {

  int x;
  int y;

  public SnakeBody(int x, int y) {
    this.x = x;
    this.y = y;
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
