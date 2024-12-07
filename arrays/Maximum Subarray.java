
/**
 * Solution class for finding the maximum subarray sum using Kadane's Algorithm
 * Time Complexity: O(n) where n is the length of input array
 * Space Complexity: O(1) as we only use two variables
 */
class Solution {

    /**
     * Finds the maximum sum of any contiguous subarray within the given array
     *
     * @param nums Input array of integers
     * @return Maximum subarray sum
     */
    public int maxSubArray(int[] nums) {
        // Initialize maxSoFar and maxEndingHere with the first element
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // Update maxEndingHere
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            // Update maxSoFar
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }

        return maxSoFar; // Return the maximum subarray sum
    }

    /**
     * Test cases to verify the maxSubArray implementation
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array with both positive and negative numbers
        int[] test1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        assert solution.maxSubArray(test1) == 6 : "Test Case 1 Failed";

        // Test Case 2: Array with all negative numbers
        int[] test2 = {-1, -2, -3, -4};
        assert solution.maxSubArray(test2) == -1 : "Test Case 2 Failed";

        // Test Case 3: Array with all positive numbers
        int[] test3 = {1, 2, 3, 4};
        assert solution.maxSubArray(test3) == 10 : "Test Case 3 Failed";

        // Test Case 4: Single element array
        int[] test4 = {5};
        assert solution.maxSubArray(test4) == 5 : "Test Case 4 Failed";

        // Test Case 5: Array with alternating positive and negative numbers
        int[] test5 = {1, -1, 1, -1, 1};
        assert solution.maxSubArray(test5) == 1 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
