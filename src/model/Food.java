package model;

import java.util.Random;
import java.awt.Color;

public class Food {

  private int x;
  private int y;
  private int size;
  private Effect effect;
  private Color color;

  public Food() {
    this.init();
  }

  private void init() {
    Random random = new Random();
    this.x = random.nextInt(1280);
    this.y = random.nextInt(720);
    this.size = random.nextInt(5) + 2;
    int r = random.nextInt(256);
    int g = random.nextInt(256);
    int b = random.nextInt(256);
    this.color = new Color(r, g, b);
    this.effect = Effect.values()[random.nextInt(Effect.values().length)];
  }

  public int getX() {
    return this.x;
  }

  public int getY() {
    return this.y;
  }

  public int getSize() {
    return this.size;
  }

  public Effect getEffect() {
    return this.effect;
  }

  public Color getColor() {
    return this.color;
  }

}
