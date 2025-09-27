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
public class TestRunnerPrintAnimalWindows {
  public static void main(String[] args) {
    // The i'th input will be used as input to the i'th printAnimal call.
    List<String[][]> inputs = new ArrayList<>();
    // The console (System.out.println) output of the i'th execution of printAnimal
    // is matched against the i'th expectation
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

    if(inputs.size() != expectedOutputs.size()) {
      System.out.println("You misconfigured your tests. There are (" + inputs.size() + ") inputs but (" + expectedOutputs.size() + ") expected values.");
      System.exit(0);
    }

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
