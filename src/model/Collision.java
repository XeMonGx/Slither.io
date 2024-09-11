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
    int foodSize = food.getSize(); // Get size of food
    if (snakeX > food.getX() - snakeSize - foodSize &&
        snakeX < food.getX() + snakeSize + foodSize &&
        snakeY > food.getY() - snakeSize - foodSize &&
        snakeY < food.getY() + snakeSize + foodSize) { // Check if snake is on food
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

  private boolean isSnake(Snake snake) {
    int snakeX = snake.getSegments().get(0).getX(); // Get head of snake X
    int snakeY = snake.getSegments().get(0).getY(); // Get head of snake Y
    int snakeSize = snake.getSize(); // Get size of snake
    for (Snake otherSnake : this.snakes) {
      for (SnakeSegment otherSegment : otherSnake.getSegments()) {
        if (snake != otherSnake) { // Check if snake is not itself
          if (snakeX > otherSegment.getX() - snakeSize * 2 &&
              snakeX < otherSegment.getX() + snakeSize * 2 &&
              snakeY > otherSegment.getY() - snakeSize * 2 &&
              snakeY < otherSegment.getY() + snakeSize * 2) { // Check if snake
            return true;
          }
        }
      }
    }
    return false;
  }

  public void check() {
    for (Snake snake : this.snakes) {
      eatFood(snake);
      if (isSnake(snake) == true) {
        snake.Dead();
      }
    }
  }
}
