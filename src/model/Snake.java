package model;

import java.util.List;
import java.util.Random;
import java.awt.Color;
import java.util.ArrayList;

import controller.ControlMode;
import controller.Direction;
import controller.KeyboardController;
import controller.MouseController;

public class Snake {

  private List<SnakeSegment> segments;
  private KeyboardController KeyController;
  private MouseController MouseController;
  private ControlMode controlMode;
  private Direction direction;
  private Color color;
  private int speed;
  private int size;
  private int space;

  public Snake(KeyboardController KeyController, MouseController MouseController) {
    this.KeyController = KeyController;
    this.MouseController = MouseController;
    this.segments = new ArrayList<SnakeSegment>();
    this.init();
  }

  private void init() {
    // Initialiser le serpent
    this.speed = 1;
    this.exp = 0;
    this.size = 20;
    this.space = 10;
    Random random = new Random();
    this.color = new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    this.controlMode = ControlMode.KEYBOARD;
    this.direction = Direction.RIGHT;
    this.segments.add(new SnakeHead(speed, direction));
  }

  public void update() {
    // Mettre à jour le serpent
    if (controlMode == ControlMode.KEYBOARD) {
      this.direction = KeyController.getDirection();
    } else if (controlMode == ControlMode.MOUSE) {

    }
    move();
  }

  public void move() {
    ((SnakeHead) segments.get(0)).setDirection(direction); // Cast to SnakeHead
    for (SnakeSegment segment : segments) {
      segment.move(); // Call move() method from SnakeSegment interface
    }
  }

  public void grow() {

    int previousX = segments.get(segments.size() - 1).getX();
    int previousY = segments.get(segments.size() - 1).getY();
    SnakeSegment lastSegment = segments.get(segments.size() - 1);

    switch (direction) {
      case UP:
        segments.add(new SnakeBody(lastSegment, previousX, previousY + space, space));
        break;
      case DOWN:
        segments.add(new SnakeBody(lastSegment, previousX, previousY - space, space));
        break;
      case LEFT:
        segments.add(new SnakeBody(lastSegment, previousX + space, previousY, space));
        break;
      case RIGHT:
        segments.add(new SnakeBody(lastSegment, previousX - space, previousY, space));
        break;
      default:
        break;
    }
  }

  public List<SnakeSegment> getSegments() {
    return this.segments;
  }

  public int getSize() {
    return size;
  }

  public Color getColor() {
    return color;
  }

}
