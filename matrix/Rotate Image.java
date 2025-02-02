package matrix;

/**
 * Solution for rotating a square matrix 90 degrees clockwise Time Complexity:
 * O(n^2) where n is the dimension of the matrix Space Complexity: O(1) as we
 * modify the matrix in-place
 */
class Solution {

    /**
     * Rotates the given n x n matrix by 90 degrees clockwise in-place The
     * rotation is performed in two steps: 1. Transpose the matrix (convert rows
     * to columns) 2. Reverse each row of the transposed matrix
     *
     * @param matrix The input square matrix to be rotated
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // Transpose the matrix (convert rows to columns)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row to get the 90-degree rotated matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = temp;
            }
        }
    }

    /**
     * Test cases to verify the rotation functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: 3x3 matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        System.out.println("Test Case 1 - Before rotation:");
        printMatrix(matrix1);
        solution.rotate(matrix1);
        System.out.println("After rotation:");
        printMatrix(matrix1);

        // Test Case 2: 4x4 matrix
        int[][] matrix2 = {
            {5, 1, 9, 11},
            {2, 4, 8, 10},
            {13, 3, 6, 7},
            {15, 14, 12, 16}
        };
        System.out.println("\nTest Case 2 - Before rotation:");
        printMatrix(matrix2);
        solution.rotate(matrix2);
        System.out.println("After rotation:");
        printMatrix(matrix2);
    }

    /**
     * Helper method to print the matrix
     *
     * @param matrix The matrix to be printed
     */
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
