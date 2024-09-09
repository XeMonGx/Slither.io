package model;

import java.util.ArrayList;

public class Collision {

  private ArrayList<Snake> snakes;
  private ArrayList<Food> foods;

  public Collision(ArrayList<Snake> snakes, ArrayList<Food> foods) {
    this.snakes = snakes;
    this.foods = foods;
  }

  public void update() {
    check();
  }

  private boolean isFood(Snake snake, Food food) {
    int snakeX = snake.getSegments().get(0).getX(); // Get head of snake X
    int snakeY = snake.getSegments().get(0).getY(); // Get head of snake Y
    int snakeSize = snake.getSize(); // Get size of snake
    if (snakeX > food.getX() - snakeSize &&
        snakeX < food.getX() + snakeSize &&
        snakeY > food.getY() - snakeSize &&
        snakeY < food.getY() + snakeSize) { // Check if snake is on food
      return true;
    }
    return false;
  }

  private void eatFood(Snake snake) {
    for (Food food : this.foods) {
      if (isFood(snake, food)) { // Check if snake is on food
        snake.addExp(food.getSize()); // Add exp to snake
        this.foods.remove(food); // Remove food
        break;
      }
    }
  }

  public void check() {
    for (Snake snake : this.snakes) {
      eatFood(snake);
    }
  }
}
