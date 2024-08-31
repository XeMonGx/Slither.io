package model;

import java.util.List;

import controller.Direction;
import controller.KeyboardController;
import controller.MouseController;

public class Snake {

  private List<SnakeSegment> segments;
  private KeyboardController KeyController;
  private MouseController MouseController;
  private Direction direction;
  private int speed;

  public Snake(KeyboardController KeyController, MouseController MouseController) {
    this.KeyController = KeyController;
    this.MouseController = MouseController;
    this.init();
  }

  public void init() {
    // Initialiser le serpent

    segments.clear();
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

}
