package graph;

import java.util.HashSet;
import java.util.Set;

/**
 * Solution for finding the longest consecutive sequence in an array.
 *
 * Problem: Given an unsorted array of integers nums, return the length of the
 * longest consecutive elements sequence.
 *
 * Algorithm: 1. Create a HashSet to store all numbers for O(1) lookup 2. For
 * each number in the set: - If it's the start of a sequence (no number-1
 * exists) - Count consecutive numbers until sequence breaks 3. Keep track of
 * the longest sequence found
 *
 * Time Complexity: O(n) where n is the length of input array Space Complexity:
 * O(n) to store numbers in HashSet
 */
class Solution {

    /**
     * Finds the length of the longest consecutive sequence in the given array.
     *
     * @param nums Array of integers to find consecutive sequence in
     * @return Length of the longest consecutive sequence
     */
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }

                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }

        return longestStreak;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case with consecutive sequence
        int[] test1 = {100, 4, 200, 1, 3, 2};
        assert solution.longestConsecutive(test1) == 4 : "Test case 1 failed";

        // Test case 2: Empty array
        int[] test2 = {};
        assert solution.longestConsecutive(test2) == 0 : "Test case 2 failed";

        // Test case 3: Array with single element
        int[] test3 = {1};
        assert solution.longestConsecutive(test3) == 1 : "Test case 3 failed";

        // Test case 4: Array with no consecutive sequence
        int[] test4 = {2, 4, 6, 8};
        assert solution.longestConsecutive(test4) == 1 : "Test case 4 failed";

        // Test case 5: Array with duplicate elements
        int[] test5 = {1, 2, 2, 3, 4, 4, 5};
        assert solution.longestConsecutive(test5) == 5 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
