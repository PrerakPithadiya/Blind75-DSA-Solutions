
/**
 * Solution for LeetCode Problem: Unique Paths
 *
 * Problem Description:
 * Given a m x n grid, a robot starts from the top-left corner (0,0) and tries to reach
 * the bottom-right corner (m-1, n-1). The robot can only move either down or right at any point.
 * Calculate the total number of possible unique paths the robot can take.
 *
 * Approach:
 * - Uses Dynamic Programming with a 2D table
 * - Each cell dp[i][j] represents the number of unique paths to reach that cell
 * - Base cases: First row and first column cells have only 1 possible path
 * - For other cells: dp[i][j] = dp[i-1][j] + dp[i][j-1]
 *
 * Time Complexity: O(m*n) where m and n are the dimensions of the grid
 * Space Complexity: O(m*n) to store the DP table
 */
class Solution {

    /**
     * Calculates the number of unique paths from top-left to bottom-right
     * corner.
     *
     * @param m Number of rows in the grid
     * @param n Number of columns in the grid
     * @return Total number of unique paths
     * @throws IllegalArgumentException if m or n is less than 1
     */
    public int uniquePaths(int m, int n) {
        // Input validation
        if (m < 1 || n < 1) {
            throw new IllegalArgumentException("Grid dimensions must be positive");
        }

        // DP table
        int[][] dp = new int[m][n];

        // Initialize the first row and first column
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // Fill the DP table
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        // The bottom-right corner will have the result
        return dp[m - 1][n - 1];
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3x2 grid
        assert solution.uniquePaths(3, 2) == 3 : "Test Case 1 Failed";

        // Test Case 2: 7x3 grid
        assert solution.uniquePaths(7, 3) == 28 : "Test Case 2 Failed";

        // Test Case 3: 3x3 grid
        assert solution.uniquePaths(3, 3) == 6 : "Test Case 3 Failed";

        // Test Case 4: 1x1 grid
        assert solution.uniquePaths(1, 1) == 1 : "Test Case 4 Failed";

        // Test Case 5: 3x7 grid
        assert solution.uniquePaths(3, 7) == 28 : "Test Case 5 Failed";

        try {
            // Test Case 6: Invalid input
            solution.uniquePaths(0, 5);
            assert false : "Should have thrown IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All test cases passed!");
    }
}
