package model;

import controller.Direction;

public class SnakeBody implements SnakeSegment {

  int x;
  int y;
  int speed;
  Effect effect;

  public SnakeBody(int x, int y, int speed) {
    this.x = x;
    this.y = y;
  }

  @Override
  public void move(Direction direction) {
    // Déplacer le corps du serpent
    switch (direction) {
      case UP:
        this.y -= speed;
        break;
      case DOWN:
        this.y += speed;
        break;
      case LEFT:
        this.x -= speed;
        break;
      case RIGHT:
        this.x += speed;
        break;
      default:
        break;
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
