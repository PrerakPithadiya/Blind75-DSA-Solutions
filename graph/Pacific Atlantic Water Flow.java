package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Pacific Atlantic Water Flow
 *
 * Problem Description: Given an m x n matrix of non-negative integers
 * representing the height of each unit cell in a continent, the "Pacific ocean"
 * touches the left and top edges of the matrix and the "Atlantic ocean" touches
 * the right and bottom edges.
 *
 * Water can only flow in four directions (up, down, left, or right) from a cell
 * to another one with height equal or lower.
 *
 * Find the list of grid coordinates where water can flow to both the Pacific
 * and Atlantic ocean.
 *
 * Time Complexity: O(m * n), where m and n are the dimensions of the matrix
 * Space Complexity: O(m * n) for the visited arrays
 */
class Solution {

    /**
     * Main method to find cells that can flow to both Pacific and Atlantic
     * oceans
     *
     * @param heights 2D array representing heights of land
     * @return List of coordinates [row, col] that can flow to both oceans
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0 || heights[0].length == 0) {
            return result;
        }

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Process cells adjacent to Pacific ocean (left and top edges)
        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, i, 0);
            dfs(heights, atlantic, Integer.MIN_VALUE, i, n - 1);
        }

        // Process cells adjacent to Atlantic ocean (right and bottom edges)
        for (int i = 0; i < n; i++) {
            dfs(heights, pacific, Integer.MIN_VALUE, 0, i);
            dfs(heights, atlantic, Integer.MIN_VALUE, m - 1, i);
        }

        // Collect cells that can flow to both oceans
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    /**
     * Depth-first search to mark cells that can flow to an ocean
     *
     * @param heights Matrix of land heights
     * @param visited Boolean matrix to track visited cells
     * @param height Previous cell's height
     * @param x Current row coordinate
     * @param y Current column coordinate
     */
    private void dfs(int[][] heights, boolean[][] visited, int height, int x, int y) {
        int m = heights.length;
        int n = heights[0].length;
        if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || heights[x][y] < height) {
            return;
        }

        visited[x][y] = true;
        dfs(heights, visited, heights[x][y], x + 1, y);
        dfs(heights, visited, heights[x][y], x - 1, y);
        dfs(heights, visited, heights[x][y], x, y + 1);
        dfs(heights, visited, heights[x][y], x, y - 1);
    }

    /**
     * Test cases for the Pacific Atlantic Water Flow solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Example from problem description
        int[][] heights1 = {
            {1, 2, 2, 3, 5},
            {3, 2, 3, 4, 4},
            {2, 4, 5, 3, 1},
            {6, 7, 1, 4, 5},
            {5, 1, 1, 2, 4}
        };
        System.out.println("Test Case 1:");
        System.out.println("Expected: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]");
        System.out.println("Actual: " + solution.pacificAtlantic(heights1));

        // Test Case 2: Single cell matrix
        int[][] heights2 = {{1}};
        System.out.println("\nTest Case 2:");
        System.out.println("Expected: [[0,0]]");
        System.out.println("Actual: " + solution.pacificAtlantic(heights2));

        // Test Case 3: Empty matrix
        int[][] heights3 = {};
        System.out.println("\nTest Case 3:");
        System.out.println("Expected: []");
        System.out.println("Actual: " + solution.pacificAtlantic(heights3));

        // Test Case 4: Matrix with same heights
        int[][] heights4 = {
            {1, 1},
            {1, 1}
        };
        System.out.println("\nTest Case 4:");
        System.out.println("Expected: [[0,0],[0,1],[1,0],[1,1]]");
        System.out.println("Actual: " + solution.pacificAtlantic(heights4));
    }
}
