import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Intended to be run on Mac and Unix where System.out.println
 * produces a "\n" sequence.
 *
 * If it doesn't work on Windows, see: TestRunnerPrintAnimalWindows
 * which checks for the "\r\n" sequence.
 */
public class TestRunnerPrintAnimal {
  public static void main(String[] args) {
    List<String[][]> inputs = new ArrayList<>();
    List<String> expectedOutputs = new ArrayList<>();

    inputs.add(new String[][] { { "X" } });
    expectedOutputs.add("[X]\n");

    inputs.add(new String[][] { { "X", "O" } });
    expectedOutputs.add("[X, O]\n");

    inputs.add(new String[][] { { "0"}, {"X"}});
    expectedOutputs.add("[0]\n[X]\n");

    inputs.add(new String[][] {
      { "O", "O" , "O" , "X", "X"},
      { "X", "X" , "X" , "X", "O"},
    });
    expectedOutputs.add(
      "[O, O, O, X, X]\n" +
      "[X, X, X, X, O]\n"
    );

    inputs.add(new String[][] {
      { "X", "O" , "O"},
      { "X", "X" , "X"},
      { "X", "O" , "X"},
    });
    expectedOutputs.add(
      "[X, O, O]\n" +
      "[X, X, X]\n" +
      "[X, O, X]\n"
    );

    // Begin tests of flipAnimalHorizontal
    inputs.add(AnimalRecognition.flipAnimalHorizontal(
      new String[][] {
        { "O", "O" , "O" , "X", "X"},
        { "X", "X" , "X" , "X", "O"},
      }
    ));
    expectedOutputs.add(
      "[X, X, O, O, O]\n" +
      "[O, X, X, X, X]\n"
    );

    // Begin tests of flipRotateAnimal
    inputs.add(AnimalRecognition.rotateAnimal90degrees(
            new String[][] {
                    { "O", "O" , "O" , "X", "X"},
                    { "X", "X" , "X" , "X", "O"},
            }
    ));
    expectedOutputs.add(
      "[X, O]\n" +
      "[X, X]\n" +
      "[O, X]\n" +
      "[O, X]\n" +
      "[O, X]\n"
    );

    int score = 0;
    for(int i = 0 ; i < inputs.size(); i++) {
      String[][] input = inputs.get(i);
      String expectedOutput = expectedOutputs.get(i);

      // Redirect System.out.println to print to the in-memory buffer
      // instead of the console
      PrintStream originalOut = System.out;
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream testOut = new PrintStream(baos);
      System.setOut(testOut);

      // Capture the output
      AnimalRecognition.printAnimal(input);
      String output  = baos.toString();

      // Restore System.out.println so we communicate back to end user .
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
