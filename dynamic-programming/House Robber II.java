
/**
 * House Robber II - Dynamic Programming Solution
 *
 * Problem Description:
 * You are a professional robber planning to rob houses arranged in a circle.
 * Each house has a certain amount of money stashed. All houses at this place are arranged in a circle.
 * That means the first house is the neighbor of the last one. Meanwhile, adjacent houses have security systems
 * connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *
 * Approach:
 * 1. Since houses are in a circle, we cannot rob both first and last house
 * 2. We break this into two subproblems:
 *    a) Rob houses from index 0 to n-2 (excluding last house)
 *    b) Rob houses from index 1 to n-1 (excluding first house)
 * 3. Take maximum of these two scenarios
 *
 * Time Complexity: O(n) where n is the number of houses
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Main method to solve the House Robber II problem
     *
     * @param nums array representing money in each house
     * @return maximum amount of money that can be robbed
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Get max money if we rob houses 0 to n-2
        int max1 = robRange(nums, 0, nums.length - 2);
        // Get max money if we rob houses 1 to n-1
        int max2 = robRange(nums, 1, nums.length - 1);

        return Math.max(max1, max2);
    }

    /**
     * Helper method to solve the original house robber problem for a range
     *
     * @param nums array representing money in each house
     * @param start starting index of the range
     * @param end ending index of the range
     * @return maximum amount that can be robbed in the given range
     */
    private int robRange(int[] nums, int start, int end) {
        int prevTwo = 0;   // max money if we rob up to two houses before the current one
        int prevOne = 0;   // max money if we rob up to the house before the current one
        int current = 0;   // max money if we rob up to the current house

        for (int i = start; i <= end; i++) {
            current = Math.max(prevOne, prevTwo + nums[i]);
            prevTwo = prevOne;
            prevOne = current;
        }

        return current;
    }

    /**
     * Test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal case
        assert solution.rob(new int[]{2, 3, 2}) == 3 : "Test case 1 failed";

        // Test Case 2: Another normal case
        assert solution.rob(new int[]{1, 2, 3, 1}) == 4 : "Test case 2 failed";

        // Test Case 3: Single element
        assert solution.rob(new int[]{1}) == 1 : "Test case 3 failed";

        // Test Case 4: Two elements
        assert solution.rob(new int[]{1, 2}) == 2 : "Test case 4 failed";

        // Test Case 5: Empty array
        assert solution.rob(new int[]{}) == 0 : "Test case 5 failed";

        // Test Case 6: Null input
        assert solution.rob(null) == 0 : "Test case 6 failed";

        // Test Case 7: Larger array
        assert solution.rob(new int[]{1, 2, 3, 4, 5, 1, 2, 3, 4, 5}) == 16 : "Test case 7 failed";

        System.out.println("All test cases passed!");
    }
}
