package model;

import java.util.ArrayList;

public class SnakeAI extends Snake {

  private ArrayList<Food> foods;

  public SnakeAI(ArrayList<Food> foods) {
    super(null, null);
    this.foods = foods;
    this.segments = new ArrayList<SnakeSegment>();
    this.init();
  }

  @Override
  public void update() {
    // Mettre à jour le serpent
    findFood();
    if (enoughExp()) {
      grow();
    }
    move();
  }

  public void findFood() {
    // Trouver la nourriture
    Food nearestFood = null;
    double minDistance = Double.MAX_VALUE;
    for (Food food : foods) {
      double distance = Math.sqrt(Math.pow(food.getX() - this.segments.get(0).getX(), 2)
          + Math.pow(food.getY() - this.segments.get(0).getY(), 2));
      if (distance < minDistance) {
        minDistance = distance;
        nearestFood = food;
      }
    }
    if (nearestFood != null) {
      if (nearestFood.getX() < this.segments.get(0).getX()) {
        this.direction = Direction.LEFT;
      } else if (nearestFood.getX() > this.segments.get(0).getX()) {
        this.direction = Direction.RIGHT;
      } else if (nearestFood.getY() < this.segments.get(0).getY()) {
        this.direction = Direction.UP;
      } else if (nearestFood.getY() > this.segments.get(0).getY()) {
        this.direction = Direction.DOWN;
      }
    }
  }

}
