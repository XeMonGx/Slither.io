package model;

import java.util.List;
import java.util.ArrayList;

import controller.Direction;
import controller.KeyboardController;
import controller.MouseController;

public class Snake {

  private List<SnakeSegment> segments;
  private KeyboardController KeyController;
  private MouseController MouseController;
  private Direction direction;
  private int speed;
  private int size;

  public Snake(KeyboardController KeyController, MouseController MouseController) {
    this.KeyController = KeyController;
    this.MouseController = MouseController;
    this.segments = new ArrayList<SnakeSegment>();
    this.init();
  }

  public void init() {
    // Initialiser le serpent
    speed = 1;
    size = 10;
    segments.add(new SnakeHead(speed));
    direction = Direction.RIGHT;
  }

  public void update() {
    // Mettre à jour le serpent
    direction = KeyController.getDirection();
    move();
  }

  public void move() {
    // Déplacer le serpent
    for (SnakeSegment segment : segments) {
      segment.move(direction);
    }
  }

  public void grow(int x, int y) {
    // Faire grandir le serpent
    segments.add(new SnakeBody(x, y, speed));
  }

  public List<SnakeSegment> getSegments() {
    return this.segments;
  }

  public int getSize() {
    return size;
  }

}
