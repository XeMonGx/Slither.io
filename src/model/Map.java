package model;

import java.util.ArrayList;

public class Map {

  public int width;
  public int height;
  public ArrayList<Snake> snakes;

  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    this.init();
  }

  public void init() {
    this.snakes = new ArrayList<Snake>();
  }

  public void update() {
    for (Snake snake : this.snakes) {
      snake.update();
    }
  }

  public void addSnake(Snake snake) {
    this.snakes.add(snake);
  }

  public void removeSnake(Snake snake) {
    this.snakes.remove(snake);
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public ArrayList<Snake> getSnakes() {
    return this.snakes;
  }

}
