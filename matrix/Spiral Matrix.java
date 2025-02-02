package matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for the Spiral Matrix problem. Given an m x n matrix, returns all
 * elements of the matrix in spiral order. Time Complexity: O(m*n) where m is
 * number of rows and n is number of columns Space Complexity: O(1) excluding
 * the output array
 */
class Solution {

    /**
     * Returns all elements of the matrix in spiral order. The spiral order
     * starts from the top-left corner and moves: right -> down -> left -> up,
     * and repeats until all elements are visited.
     *
     * @param matrix The input matrix (2D integer array)
     * @return List containing elements in spiral order
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // Traverse from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            if (top <= bottom) {
                // Traverse from right to left
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if (left <= right) {
                // Traverse from bottom to top
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }

        return result;
    }

    /**
     * Test cases to verify the spiralOrder implementation
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test Case 1: " + solution.spiralOrder(matrix1));
        // Expected output: [1,2,3,6,9,8,7,4,5]

        // Test Case 2: Single row matrix
        int[][] matrix2 = {{1, 2, 3, 4}};
        System.out.println("Test Case 2: " + solution.spiralOrder(matrix2));
        // Expected output: [1,2,3,4]

        // Test Case 3: Single column matrix
        int[][] matrix3 = {{1}, {2}, {3}};
        System.out.println("Test Case 3: " + solution.spiralOrder(matrix3));
        // Expected output: [1,2,3]

        // Test Case 4: Empty matrix
        int[][] matrix4 = {};
        System.out.println("Test Case 4: " + solution.spiralOrder(matrix4));
        // Expected output: []

        // Test Case 5: Rectangular matrix
        int[][] matrix5 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("Test Case 5: " + solution.spiralOrder(matrix5));
        // Expected output: [1,2,3,4,8,12,11,10,9,5,6,7]
    }
}
