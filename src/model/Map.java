package model;

import java.util.ArrayList;

public class Map {

  private int width;
  private int height;
  private ArrayList<Snake> snakes;
  private ArrayList<Food> foods;
  private int maxSnakes;
  private int maxFoods;

  public Map(int width, int height) {
    this.width = width;
    this.height = height;
    this.init();
  }

  public void init() {
    this.snakes = new ArrayList<Snake>();
    this.maxFoods = 50;
    this.foods = new ArrayList<Food>();
  }

  public void generateFoods() {
    while (this.foods.size() < this.maxFoods) {
      this.foods.add(new Food());
    }
  }

  public void update() {
    for (Snake snake : this.snakes) {
      snake.update();
    }
    generateFoods();
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
