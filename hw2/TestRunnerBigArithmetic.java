import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//
public class TestRunnerBigArithmetic {
  public static void main(String[] args) {
    List<int[]> inputMultipliers = new ArrayList<>();
    List<int[]> inputMultiplicand = new ArrayList<>();
    List<int[]> expectedOutputs = new ArrayList<>();

    // Begin testing various cases related to 0
    inputMultipliers.add(new int[]{0});
    inputMultiplicand.add(new int[]{0});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{0, 0, 0});
    inputMultiplicand.add(new int[]{0});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{});
    inputMultiplicand.add(new int[]{0});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{});
    inputMultiplicand.add(new int[]{});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{0});
    inputMultiplicand.add(new int[]{});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{});
    inputMultiplicand.add(new int[]{0, 0, 0});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{0, 0, 0});
    expectedOutputs.add(new int[]{0});

    inputMultipliers.add(new int[]{});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{0});
    // End test cases related to 0

    // Test various forms of 1 times 1
    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{1});
    expectedOutputs.add(new int[]{1});

    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{1});

    inputMultipliers.add(new int[]{0, 0, 1});
    inputMultiplicand.add(new int[]{1});
    expectedOutputs.add(new int[]{1});

    inputMultipliers.add(new int[]{0, 0, 1});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{1});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 1});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{1});
    // End test cases related to 1 *1

    // Test various cases related to 1 * 2
    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{2});
    expectedOutputs.add(new int[]{2});

    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{0, 0, 2});
    expectedOutputs.add(new int[]{2});

    inputMultipliers.add(new int[]{0, 0, 2});
    inputMultiplicand.add(new int[]{1});
    expectedOutputs.add(new int[]{2});

    inputMultipliers.add(new int[]{0, 0, 2});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{2});

    inputMultipliers.add(new int[]{0, 0, 1});
    inputMultiplicand.add(new int[]{0, 0, 2});
    expectedOutputs.add(new int[]{2});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 1});
    inputMultiplicand.add(new int[]{0, 0, 2});
    expectedOutputs.add(new int[]{2});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 2});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{2});
    // End test cases of 1 * 2

    // Various test cases of 1 * 9
    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{9});
    expectedOutputs.add(new int[]{9});

    inputMultipliers.add(new int[]{1});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{9});

    inputMultipliers.add(new int[]{0, 0, 9});
    inputMultiplicand.add(new int[]{1});
    expectedOutputs.add(new int[]{9});

    inputMultipliers.add(new int[]{0, 0, 9});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{9});

    inputMultipliers.add(new int[]{0, 0, 1});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{9});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 1});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{9});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 9});
    inputMultiplicand.add(new int[]{0, 0, 1});
    expectedOutputs.add(new int[]{9});
    // End various test cases of 1 * 9

    // Various test cases of 4 * 9
    inputMultipliers.add(new int[]{4});
    inputMultiplicand.add(new int[]{9});
    expectedOutputs.add(new int[]{3, 6});

    inputMultipliers.add(new int[]{4});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{3, 6});

    inputMultipliers.add(new int[]{0, 0, 9});
    inputMultiplicand.add(new int[]{4});
    expectedOutputs.add(new int[]{3, 6});

    inputMultipliers.add(new int[]{0, 0, 9});
    inputMultiplicand.add(new int[]{0, 0, 4});
    expectedOutputs.add(new int[]{3, 6});

    inputMultipliers.add(new int[]{0, 0, 4});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{3, 6});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 4});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{3, 6});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 9});
    inputMultiplicand.add(new int[]{0, 0, 4});
    expectedOutputs.add(new int[]{3, 6});
    // End various test cases of 4 * 9

    // Various test cases of 10 * 9
    inputMultipliers.add(new int[]{1, 0});
    inputMultiplicand.add(new int[]{9});
    expectedOutputs.add(new int[]{9, 0});

    inputMultipliers.add(new int[]{1, 0});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{9, 0});

    inputMultipliers.add(new int[]{0, 0, 9});
    inputMultiplicand.add(new int[]{1, 0});
    expectedOutputs.add(new int[]{9, 0});

    inputMultipliers.add(new int[]{0, 0, 9});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{9, 0});

    inputMultipliers.add(new int[]{0, 1, 0});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{9, 0});

    inputMultipliers.add(new int[]{0, 0, 0, 1, 0});
    inputMultiplicand.add(new int[]{0, 0, 9});
    expectedOutputs.add(new int[]{9, 0});

    inputMultipliers.add(new int[]{0, 0, 0, 0, 9});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{9, 0});
    // End various test cases of 10 * 9

    // Various test cases of 10 * 15
    inputMultipliers.add(new int[]{1, 0});
    inputMultiplicand.add(new int[]{1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{1, 0});
    inputMultiplicand.add(new int[]{0, 1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 1, 5});
    inputMultiplicand.add(new int[]{1, 0});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 1, 5});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 1, 0});
    inputMultiplicand.add(new int[]{0, 1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 0, 0, 1, 0});
    inputMultiplicand.add(new int[]{0, 1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 0, 0, 1, 5});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{1, 5, 0});
    // End various test cases of 10 * 15

    // Various test cases of 10 * 15
    inputMultipliers.add(new int[]{1, 0});
    inputMultiplicand.add(new int[]{1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{1, 0});
    inputMultiplicand.add(new int[]{0, 1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 1, 5});
    inputMultiplicand.add(new int[]{1, 0});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 1, 5});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 1, 0});
    inputMultiplicand.add(new int[]{0, 1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 0, 0, 1, 0});
    inputMultiplicand.add(new int[]{0, 1, 5});
    expectedOutputs.add(new int[]{1, 5, 0});

    inputMultipliers.add(new int[]{0, 0, 0, 1, 5});
    inputMultiplicand.add(new int[]{0, 1, 0});
    expectedOutputs.add(new int[]{1, 5, 0});
    // End various test cases of 10 * 15

    // Various test cases of 333 * 999
    inputMultipliers.add(new int[]{3, 3, 3});
    inputMultiplicand.add(new int[]{9, 9, 9});
    expectedOutputs.add(new int[]{3, 3, 2, 6, 6, 7});

    inputMultipliers.add(new int[]{3, 3, 3});
    inputMultiplicand.add(new int[]{0, 9, 9, 9});
    expectedOutputs.add(new int[]{3, 3, 2, 6, 6, 7});

    inputMultipliers.add(new int[]{0, 3, 3, 3});
    inputMultiplicand.add(new int[]{9, 9, 9});
    expectedOutputs.add(new int[]{3, 3, 2, 6, 6, 7});

    inputMultipliers.add(new int[]{0, 3, 3, 3});
    inputMultiplicand.add(new int[]{0, 9, 9, 9});
    expectedOutputs.add(new int[]{3, 3, 2, 6, 6, 7});

    inputMultipliers.add(new int[]{0, 0, 0, 3, 3, 3});
    inputMultiplicand.add(new int[]{0, 9, 9, 9});
    expectedOutputs.add(new int[]{3, 3, 2, 6, 6, 7});

    inputMultipliers.add(new int[]{0, 0, 0, 3, 3, 3});
    inputMultiplicand.add(new int[]{9, 9, 9});
    expectedOutputs.add(new int[]{3, 3, 2, 6, 6, 7});
    // End various test cases of 333 * 999

    // Regression Ccase in my solution
    inputMultipliers.add(new int[]{3, 4});
    inputMultiplicand.add(new int[]{3, 4});
    expectedOutputs.add(new int[]{1, 1, 5, 6});

    inputMultipliers.add(new int[]{9, 9, 9});
    inputMultiplicand.add(new int[]{9, 9, 9});
    expectedOutputs.add(new int[]{9, 9, 8, 0, 0, 1});

    // Safeguard against misconfigured test cases
    if(inputMultipliers.size() != inputMultiplicand.size()) {
      System.out.println("You misconfigured your tests. There are (" + inputMultipliers.size() + ") multiplier inputs but (" + inputMultiplicand.size() + ") multiplicand inputs.");
      System.exit(-1);
    }
    if(inputMultiplicand.size() != expectedOutputs.size()) {
      System.out.println("You misconfigured your tests. There are (" + inputMultiplicand.size() + ") inputs but (" + expectedOutputs.size() + ") expected outputs.");
      System.exit(-1);
    }

    int score = 0;
    for(int i = 0 ; i < inputMultipliers.size(); i++) {
      int[] multiplier = inputMultipliers.get(i);
      int[] multiplicand = inputMultiplicand.get(i);
      int[] expectedOutput = expectedOutputs.get(i);

      int[] output = BigArithmetic.multiply(multiplier, multiplicand);

      if(Arrays.equals(output, expectedOutput)) {
        System.out.println("Passed test case: " + i );
        score++;
      } else {
        System.out.println("Failed test case: " + i );
      }

      System.out.println("Expected: ");
      System.out.println(Arrays.toString(expectedOutput));
      System.out.println("Received:");
      System.out.println(Arrays.toString(output));
      System.out.println("==============================");
      System.out.println();
    }
    System.out.println(score + " out of " + expectedOutputs.size() + " test cases passed");
  }
}
