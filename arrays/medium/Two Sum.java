
import java.util.HashMap;

/**
 * Solution class for the Two Sum problem.
 *
 * Problem Description: Given an array of integers 'nums' and an integer
 * 'target', return indices of two numbers in the array such that they add up to
 * the target. Assume exactly one solution exists.
 *
 * Time Complexity: O(n) where n is the length of the input array Space
 * Complexity: O(n) to store the HashMap
 *
 * @author Sourcegraph
 */
class Solution {

    /**
     * Finds two numbers in the array that sum up to the target value.
     *
     * @param nums An array of integers to search through
     * @param target The target sum to find
     * @return An array containing the indices of the two numbers that sum to
     * target
     */
    public int[] twoSum(int[] nums, int target) {
        // Create a hash map to store the number and its index
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement
            int complement = target - nums[i];

            // Check if the complement exists in the map
            if (map.containsKey(complement)) {
                // If it exists, return the indices
                return new int[]{map.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map
            map.put(nums[i], i);
        }

        // If no solution is found, return an empty array (though the problem guarantees one solution)
        return new int[0];
    }

    /**
     * Test cases to verify the solution.
     *
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        assert result1[0] == 0 && result1[1] == 1 : "Test Case 1 Failed";

        // Test Case 2: Numbers in different order
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        assert result2[0] == 1 && result2[1] == 2 : "Test Case 2 Failed";

        // Test Case 3: Same number used twice
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        assert result3[0] == 0 && result3[1] == 1 : "Test Case 3 Failed";

        // Test Case 4: Larger numbers
        int[] nums4 = {-1, -2, -3, -4, -5};
        int target4 = -8;
        int[] result4 = solution.twoSum(nums4, target4);
        assert result4[0] == 2 && result4[1] == 4 : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
