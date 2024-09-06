package model;

import java.util.Random;

import controller.Direction;

public class SnakeHead implements SnakeSegment {

  private int x;
  private int y;
  private int speed;
  private Direction direction;

  public SnakeHead(int speed, Direction direction) {
    this.direction = direction;
    this.speed = speed;
    init();
  }

  public void init() {
    // Initialiser la tête du serpent
    Random random = new Random();
    this.x = random.nextInt(120);
    this.y = random.nextInt(120);
  }

  @Override
  public void move() {
    // Déplacer la tête du serpent
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

  public Direction getDirection() {
    return direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
