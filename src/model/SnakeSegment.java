package model;

import controller.Direction;

public interface SnakeSegment {

  void move(Direction direction);

  int getX();

  int getY();
}
