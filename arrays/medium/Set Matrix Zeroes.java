
/**
 * Solution for the Set Matrix Zeroes problem.
 * Time Complexity: O(M * N) where M is the number of rows and N is the number of columns
 * Space Complexity: O(1) as we use the first row and column as markers
 */
class Solution {

    /**
     * Sets entire rows and columns to zero if a cell contains zero. Uses the
     * first row and column as markers to track which rows and columns should be
     * set to zero.
     *
     * Algorithm: 1. Check if first row and column need to be set to zero 2. Use
     * first row and column as markers for other cells 3. Set cells to zero
     * based on markers 4. Set first row and column to zero if needed
     *
     * @param matrix The input matrix to be modified
     * @throws IllegalArgumentException if matrix is null or empty
     */
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            throw new IllegalArgumentException("Matrix cannot be null or empty");
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Determine if first row or first column need to be zero
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Use first row and column as markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix cells to zero based on markers
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row and column to zero if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }
        if (firstColZero) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    /**
     * Test cases for the setZeroes method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case
        int[][] matrix1 = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        solution.setZeroes(matrix1);
        assert matrix1[1][0] == 0 && matrix1[1][2] == 0 && matrix1[0][1] == 0 && matrix1[2][1] == 0;

        // Test Case 2: Multiple zeros
        int[][] matrix2 = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        solution.setZeroes(matrix2);
        assert matrix2[1][0] == 0 && matrix2[1][3] == 0;

        // Test Case 3: Single cell matrix
        int[][] matrix3 = {{1}};
        solution.setZeroes(matrix3);
        assert matrix3[0][0] == 1;

        // Test Case 4: First row and column with zeros
        int[][] matrix4 = {{0, 1, 2}, {3, 0, 5}, {6, 7, 8}};
        solution.setZeroes(matrix4);
        assert matrix4[0][1] == 0 && matrix4[1][0] == 0;

        System.out.println("All test cases passed!");
    }
}
