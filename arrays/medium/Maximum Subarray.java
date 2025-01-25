package arrays.medium;

/**
 * Maximum Subarray - Find the contiguous subarray with the largest sum
 *
 * Problem Description: Given an integer array nums, find the contiguous
 * subarray (containing at least one number) which has the largest sum and
 * return its sum.
 *
 * Approach: Uses Kadane's Algorithm with Time Complexity O(n) and Space
 * Complexity O(1) 1. Initialize maxSum and currentSum with first element 2. For
 * each element, decide whether to: - Start new subarray from current element
 * (nums[i]) - Extend previous subarray (currentSum + nums[i]) 3. Update maxSum
 * if currentSum is larger
 *
 * Example: Input: [-2,1,-3,4,-1,2,1,-5,4] Output: 6 Explanation: [4,-1,2,1] has
 * the largest sum = 6
 */
class Solution {

    /**
     * Finds the maximum sum of any contiguous subarray within the input array
     *
     * @param nums Input array of integers
     * @return Maximum sum of any contiguous subarray
     * @throws IllegalArgumentException if input array is null or empty
     */
    public int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    /**
     * Test cases to verify the functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case with mixed positive and negative numbers
        assert solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}) == 6;

        // Test Case 2: All negative numbers
        assert solution.maxSubArray(new int[]{-1, -2, -3, -4}) == -1;

        // Test Case 3: All positive numbers
        assert solution.maxSubArray(new int[]{1, 2, 3, 4}) == 10;

        // Test Case 4: Single element array
        assert solution.maxSubArray(new int[]{5}) == 5;

        // Test Case 5: Array with alternating positive and negative numbers
        assert solution.maxSubArray(new int[]{1, -1, 2, -2, 3, -3}) == 3;

        System.out.println("All test cases passed!");
    }
}
