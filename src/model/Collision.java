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

  public void check() {
    for (Snake snake : snakes) {
      int halfSize = snake.getSize() / 2;
      for (Food food : foods) {
        if (snake.getSegments().get(0).getX() >= food.getX() - halfSize &&
            snake.getSegments().get(0).getX() <= food.getX() + halfSize &&
            snake.getSegments().get(0).getY() >= food.getY() - halfSize &&
            snake.getSegments().get(0).getY() <= food.getY() + halfSize) {
          snake.grow();
          foods.remove(food);
          break;
        }
      }
    }
  }

}
