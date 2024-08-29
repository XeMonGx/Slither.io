package model;

import java.util.List;

public class Snake {

  private List<SnakeSegment> segments;

  public Snake(List<SnakeSegment> segments) {
    this.segments = segments;
  }

  public List<SnakeSegment> getSegments() {
    return this.segments;
  }

}
