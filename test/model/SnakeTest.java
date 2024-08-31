package test.model;

import java.awt.RenderingHints.Key;

import controller.KeyboardController;
import controller.MouseController;
import model.Snake;

public class SnakeTest {
  public static void main(String[] args) {
    KeyboardController keyController = new KeyboardController();
    MouseController mouseController = new MouseController();
    Snake snake = new Snake(keyController, mouseController);
  }
}
