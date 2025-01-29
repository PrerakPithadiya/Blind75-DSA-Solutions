
/**
 * Solution for the House Robber problem.
 *
 * Problem Description:
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount
 * of money stashed. All houses at this place are arranged in a row. You cannot rob adjacent houses
 * as it will automatically contact the police. Given an array of non-negative integers representing
 * the amount of money at each house, determine the maximum amount of money you can rob tonight
 * without alerting the police.
 *
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(n) to store the dp array
 */
class Solution {

    /**
     * Calculates the maximum amount of money that can be robbed.
     *
     * @param nums Array of non-negative integers representing money in each
     * house
     * @return Maximum amount that can be robbed without alerting police
     */
    public int rob(int[] nums) {
        // Handle edge cases
        if (nums == null) {
            return 0;
        }

        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return nums[0];
        }

        // dp array to store the maximum money that can be robbed up to house i
        int[] dp = new int[n];

        // Base cases
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // Fill the dp array
        // At each house i, we can either:
        // 1. Skip this house and take the previous maximum (dp[i-1])
        // 2. Rob this house and add it to the maximum from two houses before (nums[i] + dp[i-2])
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
        }

        // The answer is in the last element
        return dp[n - 1];
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Empty array
        assert solution.rob(new int[]{}) == 0 : "Test case 1 failed";

        // Test case 2: Single element
        assert solution.rob(new int[]{5}) == 5 : "Test case 2 failed";

        // Test case 3: Two elements
        assert solution.rob(new int[]{1, 2}) == 2 : "Test case 3 failed";

        // Test case 4: Multiple elements
        assert solution.rob(new int[]{1, 2, 3, 1}) == 4 : "Test case 4 failed";

        // Test case 5: Larger numbers
        assert solution.rob(new int[]{2, 7, 9, 3, 1}) == 12 : "Test case 5 failed";

        // Test case 6: All same numbers
        assert solution.rob(new int[]{1, 1, 1, 1}) == 2 : "Test case 6 failed";

        // Test case 7: Null input
        assert solution.rob(null) == 0 : "Test case 7 failed";

        System.out.println("All test cases passed!");
    }
}
