package matrix;

/**
 * Solution for the Set Matrix Zeroes problem
 *
 * Problem Description: Given an m x n integer matrix, if an element is 0, set
 * its entire row and column to 0's. This should be done in-place, without using
 * any extra space.
 *
 * Time Complexity: O(M * N) where M is number of rows and N is number of
 * columns Space Complexity: O(1) as we use the first row and column as markers
 */
class Solution {

    /**
     * Sets rows and columns to zero if the cell contains zero
     *
     * Algorithm: 1. First check if first row and column contain any zeros 2.
     * Use first row and column as markers for cells that need to be set to zero
     * 3. Process the matrix (except first row and column) and mark the first
     * row and column 4. Set cells to zero based on the markers 5. Finally set
     * first row and column to zero if they originally contained zero
     *
     * @param matrix the input matrix to be modified
     */
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean firstRowZero = false;
        boolean firstColZero = false;

        // Check if first row has any zeros
        for (int j = 0; j < cols; j++) {
            if (matrix[0][j] == 0) {
                firstRowZero = true;
                break;
            }
        }

        // Check if first column has any zeros
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        // Use first row and column to mark zeros
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        // Set matrix cells to zero based on marks
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // Set first row to zero if needed
        if (firstRowZero) {
            for (int j = 0; j < cols; j++) {
                matrix[0][j] = 0;
            }
        }

        // Set first column to zero if needed
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
        SetMatrixZeroes solution = new SetMatrixZeroes();

        // Test Case 1: Matrix with single zero
        int[][] matrix1 = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        };
        System.out.println("Test Case 1:");
        solution.setZeroes(matrix1);
        printMatrix(matrix1);

        // Test Case 2: Matrix with multiple zeros
        int[][] matrix2 = {
            {0, 1, 2, 0},
            {3, 4, 5, 2},
            {1, 3, 1, 5}
        };
        System.out.println("\nTest Case 2:");
        solution.setZeroes(matrix2);
        printMatrix(matrix2);

        // Test Case 3: Matrix with no zeros
        int[][] matrix3 = {
            {1, 1},
            {1, 1}
        };
        System.out.println("\nTest Case 3:");
        solution.setZeroes(matrix3);
        printMatrix(matrix3);

        // Test Case 4: Matrix with all zeros
        int[][] matrix4 = {
            {0, 0},
            {0, 0}
        };
        System.out.println("\nTest Case 4:");
        solution.setZeroes(matrix4);
        printMatrix(matrix4);
    }

    /**
     * Helper method to print the matrix
     *
     * @param matrix the matrix to be printed
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
