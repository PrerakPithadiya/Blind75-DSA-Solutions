
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Solution class for finding the Longest Increasing Subsequence (LIS) Time
 * Complexity: O(n log n) where n is the length of the input array Space
 * Complexity: O(n) to store the subsequence
 */
class Solution {

    /**
     * Finds the length of the longest strictly increasing subsequence in an
     * array. Uses a dynamic programming approach with binary search
     * optimization.
     *
     * @param nums The input array of integers
     * @return The length of the longest increasing subsequence
     */
    public int lengthOfLIS(int[] nums) {
        List<Integer> sub = new ArrayList<>();

        for (int num : nums) {
            if (sub.size() == 0 || num > sub.get(sub.size() - 1)) {
                sub.add(num); // Append to the list if num is greater than the last element
            } else {
                // Binary search to find the position to replace
                int idx = Collections.binarySearch(sub, num);
                if (idx < 0) {
                    idx = -(idx + 1); // Get the correct insertion point if num is not found
                }
                sub.set(idx, num); // Replace the element at index idx
            }
        }

        return sub.size(); // The size of the list is the length of the LIS
    }

    /**
     * Main method to test the LIS implementation with various test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic increasing sequence
        int[] test1 = {10, 9, 2, 5, 3, 7, 101, 18};
        assert solution.lengthOfLIS(test1) == 4 : "Test Case 1 Failed";

        // Test Case 2: All elements are the same
        int[] test2 = {7, 7, 7, 7, 7};
        assert solution.lengthOfLIS(test2) == 1 : "Test Case 2 Failed";

        // Test Case 3: Strictly decreasing sequence
        int[] test3 = {9, 8, 7, 6, 5, 4, 3, 2, 1};
        assert solution.lengthOfLIS(test3) == 1 : "Test Case 3 Failed";

        // Test Case 4: Empty array
        int[] test4 = {};
        assert solution.lengthOfLIS(test4) == 0 : "Test Case 4 Failed";

        // Test Case 5: Single element
        int[] test5 = {5};
        assert solution.lengthOfLIS(test5) == 1 : "Test Case 5 Failed";

        // Test Case 6: Complex sequence
        int[] test6 = {0, 1, 0, 3, 2, 3};
        assert solution.lengthOfLIS(test6) == 4 : "Test Case 6 Failed";

        System.out.println("All test cases passed successfully!");
    }
}
