package matrix;

/**
 * Word Search - LeetCode Problem
 *
 * This class provides a solution for finding if a word exists in a 2D board of
 * characters. The word can be constructed from letters of sequentially adjacent
 * cells, where adjacent cells are horizontally or vertically neighboring. The
 * same letter cell may not be used more than once.
 *
 * Time Complexity: O(N * M * 4^L) where N and M are the dimensions of the board
 * and L is the length of the word Space Complexity: O(L) where L is the length
 * of the word due to recursion stack
 */
class WordSearch {

    /**
     * Determines if a word exists in the board.
     *
     * @param board The 2D character board
     * @param word The word to search for
     * @return true if the word exists in the board, false otherwise
     * @throws IllegalArgumentException if board is null or empty, or if word is
     * null
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0 || word == null) {
            throw new IllegalArgumentException("Invalid input: board or word cannot be null/empty");
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Performs depth-first search to find the word starting from position
     * (i,j).
     *
     * @param board The 2D character board
     * @param word The word to search for
     * @param i Current row position
     * @param j Current column position
     * @param index Current index in the word
     * @return true if the word is found starting from this position, false
     * otherwise
     */
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        if (index == word.length()) {
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index)) {
            return false;
        }

        char temp = board[i][j];
        board[i][j] = ' '; // mark as visited

        boolean found = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);

        board[i][j] = temp; // unmark

        return found;
    }

    /**
     * Test cases for the Word Search solution.
     */
    public static void main(String[] args) {
        WordSearch solution = new WordSearch();

        // Test Case 1: Basic case
        char[][] board1 = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'}
        };
        String word1 = "ABCCED";
        System.out.println("Test 1: " + solution.exist(board1, word1)); // Expected: true

        // Test Case 2: Word not found
        String word2 = "ABCB";
        System.out.println("Test 2: " + solution.exist(board1, word2)); // Expected: false

        // Test Case 3: Single character board
        char[][] board2 = {{'A'}};
        String word3 = "A";
        System.out.println("Test 3: " + solution.exist(board2, word3)); // Expected: true

        // Test Case 4: Empty word
        String word4 = "";
        try {
            solution.exist(board1, word4);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 4: Exception caught as expected");
        }

        // Test Case 5: Long winding path
        char[][] board3 = {
            {'A', 'B', 'C', 'D'},
            {'E', 'F', 'G', 'H'},
            {'I', 'J', 'K', 'L'}
        };
        String word5 = "ABFGJKL";
        System.out.println("Test 5: " + solution.exist(board3, word5)); // Expected: true
    }
}
