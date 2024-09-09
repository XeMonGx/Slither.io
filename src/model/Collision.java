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

  private boolean isFood(Snake snake) {
    int snakeX = snake.getSegments().get(0).getX(); // Get head of snake X
    int snakeY = snake.getSegments().get(0).getY(); // Get head of snake Y
    int snakeSize = snake.getSize(); // Get size of snake
    for (Food food : foods) { // Iterate over foods
      if (snakeX > food.getX() - snakeSize &&
          snakeX < food.getX() + snakeSize &&
          snakeY > food.getY() - snakeSize &&
          snakeY < food.getY() + snakeSize) { // Check if snake is on food
        foods.remove(food); // Remove food
        return true;
      }
    }
    return false;
  }

  public void check() {
    for (Snake snake : snakes) {
      if (isFood(snake)) { // Check if snake is on food
        snake.grow(); // Grow snake
      }
    }
  }

}
