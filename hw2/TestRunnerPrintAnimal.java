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
    // The i'th input will be used as input to the i'th printAnimal call.
    List<String[][]> inputs = new ArrayList<>();
    // The console (System.out.println) output of the i'th execution of printAnimal
    // is matched against the i'th expectation
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

    if(inputs.size() != expectedOutputs.size()) {
      System.out.println("You misconfigured your tests. There are (" + inputs.size() + ") inputs but (" + expectedOutputs.size() + ") expected values.");
      System.exit(-1);
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
