package model;

public class Camera {
  private int x, y;
  private int width, height;

  public Camera(int width, int height) {
    this.width = width;
    this.height = height;
    this.x = 0;
    this.y = 0;
  }

  public void update(int snakeX, int snakeY) {
    this.x = snakeX - width / 2;
    this.y = snakeY - height / 2;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }
}