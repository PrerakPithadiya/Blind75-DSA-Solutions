package TUF.arrays.easy;

/**
 * Solution class containing methods to find the second largest element in an
 * array.
 */
class Solution {

    /**
     * Finds the second largest element in an array of integers.
     *
     * @param arr The input array of integers
     * @return The second largest element in the array, or -1 if it doesn't
     * exist
     *
     * Time Complexity: O(n) where n is the length of the array Space
     * Complexity: O(1) as we only use two variables regardless of input size
     *
     * Example 1: Input: [12, 35, 1, 10, 34, 1] Output: 34 Explanation: The
     * largest element is 35 and second largest is 34
     *
     * Example 2: Input: [10, 10, 10] Output: -1 Explanation: All elements are
     * same, no second largest exists
     *
     * Example 3: Input: [2, 1] Output: 1 Explanation: 2 is largest and 1 is
     * second largest
     */
    public int getSecondLargest(int[] arr) {
        // Initialize the largest and second largest to minimum possible values
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        // Iterate through the array
        for (int num : arr) {
            // Update largest and second largest accordingly
            if (num > largest) {
                secondLargest = largest; // Update second largest before largest
                largest = num; // Update largest
            } else if (num > secondLargest && num < largest) {
                secondLargest = num; // Update second largest if num is between largest and second largest
            }
        }

        // If second largest is still Integer.MIN_VALUE, it means it doesn't exist
        return (secondLargest == Integer.MIN_VALUE) ? -1 : secondLargest;
    }

    /**
     * Test cases to verify the functionality of getSecondLargest method
     */
    public void runTests() {
        // Test Case 1: Normal array with distinct elements
        assert getSecondLargest(new int[]{12, 35, 1, 10, 34, 1}) == 34;

        // Test Case 2: Array with duplicate elements
        assert getSecondLargest(new int[]{10, 10, 10}) == -1;

        // Test Case 3: Array with negative numbers
        assert getSecondLargest(new int[]{-1, -2, -3, -4}) == -2;

        // Test Case 4: Array with two elements
        assert getSecondLargest(new int[]{2, 1}) == 1;

        // Test Case 5: Array with one element
        assert getSecondLargest(new int[]{5}) == -1;

        // Test Case 6: Array with largest element appearing multiple times
        assert getSecondLargest(new int[]{10, 5, 10, 8, 10}) == 8;

        System.out.println("All test cases passed successfully!");
    }
}
