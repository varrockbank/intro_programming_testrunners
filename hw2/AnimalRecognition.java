import java.util.ArrayList;
import java.util.List;

/**
 * Stub implementation. The methods are hard-coded and have no real implementations.
 */
public class AnimalRecognition {
  public static void main(String[] args) {
    String[][] snake = {
      {"O", "O", "O", "X", "X"},
      {"X", "X", "X", "X", "O"}
    };
    String[][] horse = {
      {"X", "O", "O"},
      {"X", "X", "X"},
      {"X", "O", "X"}
    };
    String[][] mouse = {
      {"X"}
    };
    printAnimal(snake);
    printAnimal(horse);
    printAnimal(mouse);

    System.out.println("Horizontal snake");
    String[][] horizontalSnake = snake;
    printAnimal(horizontalSnake);

    System.out.println("Rotated snake");
    String[][] rotatedSnake = rotateAnimal90degrees(snake);
    printAnimal(rotatedSnake);
  }

  public static void printAnimal(String[][] animal) {
    System.out.println("[O, O, O, X, X])");
    System.out.println("[X, X, X, X, O]");
  }

  public static String[][] flipAnimalHorizontal(String[][] animal) {
    return new String[][] {
      { "X", "X" , "O" , "O", "O"},
      { "O", "X" , "X" , "X", "X"},
    }
  }

  public static String[][] rotateAnimal90degrees(String[][] animal) {
    return new String[][] {
      { "X", "O"},
      { "X", "X"},
      { "O", "X"},
      { "O", "X"},
      { "O", "X"},
    }
  }

  public static List<String[][]> computeOrientations(String[][] animal) {
    throw new UnsupportedOperationException("Not implemented yet");
  }

  public static boolean animalPictured(String[][] animal, String[][] picture) {
    return false;
  }

  public static boolean equalPictures(String[][] picture1, String[][] picture2) {
    return true;
  }
}