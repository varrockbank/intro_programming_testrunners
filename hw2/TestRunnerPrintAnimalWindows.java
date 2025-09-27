import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Intended to be run on Windows where System.out.println
 * produces a "\r\n" sequence.
 *
 * If it doesn't work, try to Unix/Mac version: TestRunnerPrintAnimal
 * which checks for the "\n" sequence.
 */
public class TestRunnerPrintAnimal {
  public static void main(String[] args) {
    List<String[][]> inputs = new ArrayList<>();
    List<String> expectedOutputs = new ArrayList<>();

    inputs.add(new String[][] { { "X" } });
    expectedOutputs.add("[X]\r\n");

    inputs.add(new String[][] { { "X", "O" } });
    expectedOutputs.add("[X, O]\r\n");

    inputs.add(new String[][] { { "0"}, {"X"}});
    expectedOutputs.add("[0]\r\n[X]\r\n");

    inputs.add(new String[][] {
      { "O", "O" , "O" , "X", "X"},
      { "X", "X" , "X" , "X", "O"},
    });
    expectedOutputs.add(
      "[O, O, O, X, X]\r\n" +
      "[X, X, X, X, O]\r\n"
    );

    inputs.add(new String[][] {
      { "X", "O" , "O"},
      { "X", "X" , "X"},
      { "X", "O" , "X"},
    });
    expectedOutputs.add(
      "[X, O, O]\r\n" +
      "[X, X, X]\r\n" +
      "[X, O, X]\r\n"
    );

    // Begin tests of flipAnimalHorizontal
    inputs.add(AnimalRecognition.flipAnimalHorizontal(
      new String[][] {
        { "O", "O" , "O" , "X", "X"},
        { "X", "X" , "X" , "X", "O"},
      }
    ));
    expectedOutputs.add(
      "[X, X, O, O, O]\r\n" +
      "[O, X, X, X, X]\r\n"
    );

    // Begin tests of flipRotateAnimal
    inputs.add(AnimalRecognition.rotateAnimal90degrees(
            new String[][] {
                    { "O", "O" , "O" , "X", "X"},
                    { "X", "X" , "X" , "X", "O"},
            }
    ));
    expectedOutputs.add(
      "[X, O]\r\n" +
      "[X, X]\r\n" +
      "[O, X]\r\n" +
      "[O, X]\r\n" +
      "[O, X]\r\n"
    );

    int score = 0;
    for(int i = 0 ; i < inputs.size(); i++) {
      String[][] input = inputs.get(i);
      String expectedOutput = expectedOutputs.get(i);

      PrintStream originalOut = System.out;
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream testOut = new PrintStream(baos);
      System.setOut(testOut);

      // Capture the output
      AnimalRecognition.printAnimal(input);
      String output  = baos.toString();

      // Restore System.out.println`
      System.setOut(originalOut);
      if(output.equals(expectedOutput)) {
        System.out.println("Passed test case: " + i );
        score++;
      } else {
        System.out.println("Failed test case: " + i );
      }

      System.out.println("Expected: ");
      System.out.println(expectedOutput);
      System.out.println("Received:");
      System.out.println(output);
      System.out.println("==============================");
      System.out.println();
    }
    System.out.println(score + " out of " + inputs.size() + " test cases passed");
  }
}
