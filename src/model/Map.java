package model;

import java.util.ArrayList;

public class Map {

  private int width;
  private int height;
  private ArrayList<Snake> snakes;
  private ArrayList<Food> foods;
  private Collision collision;
  private int maxSnakes;
  private int maxFoods;

  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    this.init();
  }

  private void init() {
    this.snakes = new ArrayList<Snake>();
    this.maxFoods = 50;
    this.foods = new ArrayList<Food>();
    this.collision = new Collision(this.snakes, this.foods);
  }

  private void generateFoods() {
    while (this.foods.size() < this.maxFoods) {
      this.foods.add(new Food());
    }
  }

  public void update() {
    for (Snake snake : this.snakes) {
      snake.update();
      if (snake.isDead() == true) {
        for (SnakeSegment segment : snake.getSegments()) {
          foods.add(new Food(segment.getX(), segment.getY()));
        }
        this.snakes.remove(snake);
        break;
      }
    }
    generateFoods();
    this.collision.update();
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

  public ArrayList<Food> getFoods() {
    return this.foods;
  }

}
