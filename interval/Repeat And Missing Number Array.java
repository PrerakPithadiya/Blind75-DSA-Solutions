
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Solution class for finding repeated and missing numbers in an array This
 * class provides a method to find both a repeated number and a missing number
 * in a sequence of integers from 1 to N where one number is missing and one
 * number is repeated.
 *
 * Time Complexity: O(n) Space Complexity: O(1)
 */
class RepeatAndMissingNumber {

    /**
     * Finds the repeated and missing numbers in a given list of integers.
     *
     * The method uses mathematical formulas based on: 1. Sum of first N natural
     * numbers 2. Sum of squares of first N natural numbers
     *
     * @param A List of integers containing numbers from 1 to N with one missing
     * and one repeated number
     * @return ArrayList containing two integers - first the repeated number,
     * then the missing number
     * @throws IllegalArgumentException if input list is null or empty
     */
    public ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        if (A == null || A.isEmpty()) {
            throw new IllegalArgumentException("Input list cannot be null or empty");
        }

        long len = A.size();
        long sumOfN = (len * (len + 1)) / 2;
        long sumOfNSq = (len * (len + 1) * (2 * len + 1)) / 6;

        long sum = 0, sumSq = 0;
        for (int i = 0; i < len; i++) {
            sum += A.get(i);
            sumSq += (long) A.get(i) * A.get(i);
        }

        long diff = sumOfN - sum; // B - A
        long diffSq = sumOfNSq - sumSq; // B^2 - A^2

        long sumAB = diffSq / diff; // B + A

        int B = (int) ((diff + sumAB) / 2);
        int missingNumber = (int) (sumAB - B);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(missingNumber);
        result.add(B);

        return result;
    }

    /**
     * Main method with test cases to demonstrate the functionality
     */
    public static void main(String[] args) {
        RepeatAndMissingNumber solution = new RepeatAndMissingNumber();

        // Test Case 1: Basic case
        List<Integer> test1 = Arrays.asList(3, 1, 2, 5, 3);
        System.out.println("Test Case 1: " + solution.repeatedNumber(test1)); // Expected: [3, 4]

        // Test Case 2: Repeated number at start
        List<Integer> test2 = Arrays.asList(1, 1, 3, 4);
        System.out.println("Test Case 2: " + solution.repeatedNumber(test2)); // Expected: [1, 2]

        // Test Case 3: Repeated number at end
        List<Integer> test3 = Arrays.asList(1, 2, 3, 5, 5);
        System.out.println("Test Case 3: " + solution.repeatedNumber(test3)); // Expected: [5, 4]

        // Test Case 4: Larger numbers
        List<Integer> test4 = Arrays.asList(1, 2, 3, 4, 5, 6, 8, 8, 9, 10);
        System.out.println("Test Case 4: " + solution.repeatedNumber(test4)); // Expected: [8, 7]

        try {
            // Test Case 5: Empty list
            solution.repeatedNumber(new ArrayList<>());
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 5 (Empty list): " + e.getMessage());
        }

        try {
            // Test Case 6: Null input
            solution.repeatedNumber(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 6 (Null input): " + e.getMessage());
        }
    }
}
