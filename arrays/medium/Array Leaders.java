
import java.util.ArrayList;
import java.util.Collections;

/**
 * Solution class containing methods to find leaders in an array. A leader is an
 * element which is greater than all the elements to its right.
 */
class Solution {

    /**
     * Finds all the leaders in the given array. An element is a leader if it is
     * greater than or equal to all elements to its right. The rightmost element
     * is always a leader.
     *
     * @param arr Input array to find leaders in
     * @return ArrayList containing all leaders in the array in their original
     * order
     * @throws IllegalArgumentException if input array is null or empty
     */
    static ArrayList<Integer> leaders(int arr[]) {
        // Input validation
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        ArrayList<Integer> result = new ArrayList<>();
        int n = arr.length;
        int maxFromRight = arr[n - 1];
        result.add(maxFromRight);  // rightmost element is always a leader

        // Scan from right to left, keeping track of maximum so far
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] >= maxFromRight) {
                maxFromRight = arr[i];
                result.add(maxFromRight);
            }
        }

        Collections.reverse(result);  // reverse to maintain original order
        return result;
    }

    /**
     * Main method containing test cases for the leaders method.
     */
    public static void main(String[] args) {
        // Test Case 1: Normal array with multiple leaders
        int[] test1 = {16, 17, 4, 3, 5, 2};
        System.out.println("Test Case 1:");
        System.out.println("Input: " + java.util.Arrays.toString(test1));
        System.out.println("Leaders: " + leaders(test1));  // Expected: [17, 5, 2]

        // Test Case 2: Array where all elements are leaders
        int[] test2 = {5, 4, 3, 2, 1};
        System.out.println("\nTest Case 2:");
        System.out.println("Input: " + java.util.Arrays.toString(test2));
        System.out.println("Leaders: " + leaders(test2));  // Expected: [5, 4, 3, 2, 1]

        // Test Case 3: Array with single element
        int[] test3 = {1};
        System.out.println("\nTest Case 3:");
        System.out.println("Input: " + java.util.Arrays.toString(test3));
        System.out.println("Leaders: " + leaders(test3));  // Expected: [1]

        // Test Case 4: Array where only last element is leader
        int[] test4 = {1, 2, 3, 4, 5};
        System.out.println("\nTest Case 4:");
        System.out.println("Input: " + java.util.Arrays.toString(test4));
        System.out.println("Leaders: " + leaders(test4));  // Expected: [5]

        try {
            // Test Case 5: Null array (should throw exception)
            leaders(null);
        } catch (IllegalArgumentException e) {
            System.out.println("\nTest Case 5:");
            System.out.println("Successfully caught null array exception: " + e.getMessage());
        }
    }
}
