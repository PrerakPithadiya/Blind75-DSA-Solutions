
import java.util.HashMap;

/**
 * Solution class for the Two Sum problem. Given an array of integers nums and
 * an integer target, returns indices of two numbers that add up to target.
 */
class Solution {

    /**
     * Finds two numbers in the array that sum to the target value.
     *
     * @param nums An array of integers
     * @param target The target sum
     * @return An array of two integers representing the indices of numbers that
     * sum to target
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
     * Test cases to verify the twoSum function.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        int[] result1 = solution.twoSum(nums1, target1);
        System.out.println("Test Case 1: [" + result1[0] + ", " + result1[1] + "]"); // Expected: [0, 1]

        // Test Case 2: Numbers in different order
        int[] nums2 = {3, 2, 4};
        int target2 = 6;
        int[] result2 = solution.twoSum(nums2, target2);
        System.out.println("Test Case 2: [" + result2[0] + ", " + result2[1] + "]"); // Expected: [1, 2]

        // Test Case 3: Same number used twice
        int[] nums3 = {3, 3};
        int target3 = 6;
        int[] result3 = solution.twoSum(nums3, target3);
        System.out.println("Test Case 3: [" + result3[0] + ", " + result3[1] + "]"); // Expected: [0, 1]
    }
}
