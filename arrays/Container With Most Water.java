
/**
 * Solution for Container With Most Water problem
 *
 * Problem Description:
 * Given n non-negative integers height[i] where each represents a point at coordinate (i, height[i]),
 * n vertical lines are drawn such that the two endpoints of line i is at (i, height[i]) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Approach:
 * - Use two pointer technique (left and right)
 * - Calculate area between lines at each step: min(height[left], height[right]) * (right - left)
 * - Move the pointer that points to the shorter line inward
 * - Keep track of maximum area found
 *
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the maximum area that can be contained between two vertical lines
     *
     * @param height array of integers representing heights of vertical lines
     * @return maximum area that can be contained between any two lines
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            // Calculate the current area
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            // Move the pointer pointing to the shorter height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Regular case
        int[] test1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assert solution.maxArea(test1) == 49 : "Test Case 1 Failed";

        // Test Case 2: All same heights
        int[] test2 = {1, 1, 1, 1, 1};
        assert solution.maxArea(test2) == 4 : "Test Case 2 Failed";

        // Test Case 3: Increasing heights
        int[] test3 = {1, 2, 3, 4, 5};
        assert solution.maxArea(test3) == 6 : "Test Case 3 Failed";

        // Test Case 4: Minimum case
        int[] test4 = {1, 1};
        assert solution.maxArea(test4) == 1 : "Test Case 4 Failed";

        // Test Case 5: Zero height case
        int[] test5 = {0, 2, 0};
        assert solution.maxArea(test5) == 0 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
