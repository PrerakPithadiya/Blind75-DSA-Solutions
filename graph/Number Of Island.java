package graph;

/**
 * Number of Islands (LeetCode #200)
 *
 * Problem Description: Given an m x n 2D binary grid which represents a map of
 * '1's (land) and '0's (water), return the number of islands. An island is
 * surrounded by water and is formed by connecting adjacent lands horizontally
 * or vertically.
 *
 * Time Complexity: O(M × N) where M is the number of rows and N is the number
 * of columns Space Complexity: O(M × N) in worst case for the recursion stack
 */
class Solution {

    /**
     * Counts the number of islands in the given grid.
     *
     * @param grid 2D char array representing the map where '1' is land and '0'
     * is water
     * @return number of islands in the grid
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int numIslands = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        // Loop over every cell in the grid
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If the cell is land, perform DFS to mark the entire island
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j); // Perform DFS to mark the entire island
                }
            }
        }

        return numIslands;
    }

    /**
     * Performs depth-first search to mark all connected land cells as visited.
     *
     * @param grid 2D char array representing the map
     * @param row current row position
     * @param col current column position
     */
    private void dfs(char[][] grid, int row, int col) {
        int rows = grid.length;
        int cols = grid[0].length;

        // Check for bounds and whether it's water or already visited
        if (row < 0 || row >= rows || col < 0 || col >= cols || grid[row][col] == '0') {
            return;
        }

        // Mark the current cell as visited by changing it to water ('0')
        grid[row][col] = '0';

        // Explore all four possible directions (up, down, left, right)
        dfs(grid, row - 1, col); // Up
        dfs(grid, row + 1, col); // Down
        dfs(grid, row, col - 1); // Left
        dfs(grid, row, col + 1); // Right
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case with multiple islands
        char[][] grid1 = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        assert solution.numIslands(grid1) == 3 : "Test Case 1 Failed";

        // Test Case 2: Single island
        char[][] grid2 = {
            {'1', '1', '1'},
            {'1', '1', '1'},
            {'1', '1', '1'}
        };
        assert solution.numIslands(grid2) == 1 : "Test Case 2 Failed";

        // Test Case 3: No islands
        char[][] grid3 = {
            {'0', '0', '0'},
            {'0', '0', '0'},
            {'0', '0', '0'}
        };
        assert solution.numIslands(grid3) == 0 : "Test Case 3 Failed";

        // Test Case 4: Single cell island
        char[][] grid4 = {{'1'}};
        assert solution.numIslands(grid4) == 1 : "Test Case 4 Failed";

        // Test Case 5: Empty grid
        char[][] grid5 = new char[0][0];
        assert solution.numIslands(grid5) == 0 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
