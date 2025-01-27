
import java.util.HashSet;
import java.util.Set;

/**
 * Solution class for finding the longest consecutive sequence in an array.
 * LeetCode Problem: Longest Consecutive Sequence
 */
class Solution {

    /**
     * Finds the length of the longest consecutive sequence in an array of
     * integers.
     *
     * @param nums The input array of integers
     * @return The length of the longest consecutive sequence
     *
     * Time Complexity: O(n) where n is the length of the input array Space
     * Complexity: O(n) to store the HashSet
     *
     * Algorithm: 1. Handle edge cases (null or empty array) 2. Create a HashSet
     * from the input array for O(1) lookups 3. For each number in the set: -
     * Check if it's the start of a sequence (no number exists before it) - If
     * it is, count consecutive numbers following it 4. Return the maximum
     * sequence length found
     */
    public int longestConsecutive(int[] nums) {
        // Handle empty array case
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Create HashSet for O(1) lookups
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 1;

        // Check each number if it's the start of a sequence
        for (int num : numSet) {
            // Only process if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                // Count consecutive numbers
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentLength++;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal case with consecutive numbers
        int[] test1 = {100, 4, 200, 1, 3, 2};
        assert solution.longestConsecutive(test1) == 4 : "Test Case 1 Failed";

        // Test Case 2: Empty array
        int[] test2 = {};
        assert solution.longestConsecutive(test2) == 0 : "Test Case 2 Failed";

        // Test Case 3: Array with single element
        int[] test3 = {1};
        assert solution.longestConsecutive(test3) == 1 : "Test Case 3 Failed";

        // Test Case 4: Array with duplicate elements
        int[] test4 = {1, 2, 0, 1};
        assert solution.longestConsecutive(test4) == 3 : "Test Case 4 Failed";

        // Test Case 5: Array with negative numbers
        int[] test5 = {-7, -6, -5, -4, 1, 3, 4, 5};
        assert solution.longestConsecutive(test5) == 4 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
