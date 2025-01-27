
import java.util.ArrayList;
import java.util.List;

/**
 * Solution class for the Spiral Matrix problem. This class provides a method to
 * return all elements of a matrix in spiral order.
 */
class Solution {

    /**
     * Returns a list of all elements in the matrix in spiral order. The spiral
     * order starts from the top-left corner and moves right, then down, then
     * left, then up, and so on.
     *
     * Time Complexity: O(m*n) where m and n are the dimensions of the matrix
     * Space Complexity: O(1) excluding the space needed for output
     *
     * @param matrix The input matrix of integers
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
     * Main method with test cases to verify the spiralOrder implementation
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test Case 1:");
        System.out.println("Input: 3x3 matrix");
        System.out.println("Expected: [1,2,3,6,9,8,7,4,5]");
        System.out.println("Output: " + solution.spiralOrder(matrix1));

        // Test Case 2: Rectangle matrix
        int[][] matrix2 = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12}
        };
        System.out.println("\nTest Case 2:");
        System.out.println("Input: 3x4 matrix");
        System.out.println("Expected: [1,2,3,4,8,12,11,10,9,5,6,7]");
        System.out.println("Output: " + solution.spiralOrder(matrix2));

        // Test Case 3: Single row matrix
        int[][] matrix3 = {{1, 2, 3, 4}};
        System.out.println("\nTest Case 3:");
        System.out.println("Input: 1x4 matrix");
        System.out.println("Expected: [1,2,3,4]");
        System.out.println("Output: " + solution.spiralOrder(matrix3));

        // Test Case 4: Single column matrix
        int[][] matrix4 = {{1}, {2}, {3}};
        System.out.println("\nTest Case 4:");
        System.out.println("Input: 3x1 matrix");
        System.out.println("Expected: [1,2,3]");
        System.out.println("Output: " + solution.spiralOrder(matrix4));

        // Test Case 5: Empty matrix
        int[][] matrix5 = {};
        System.out.println("\nTest Case 5:");
        System.out.println("Input: Empty matrix");
        System.out.println("Expected: []");
        System.out.println("Output: " + solution.spiralOrder(matrix5));
    }
}
