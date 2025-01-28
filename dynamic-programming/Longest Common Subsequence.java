
/**
 * Solution class for finding the Longest Common Subsequence (LCS) of two strings.
 *
 * The LCS problem is a classic dynamic programming problem that finds the longest
 * subsequence common to two sequences. A subsequence is a sequence that appears in
 * the same relative order but not necessarily contiguous.
 *
 * Time Complexity: O(m*n) where m and n are lengths of input strings
 * Space Complexity: O(m*n) for the DP table
 */
class Solution {

    /**
     * Finds the length of the longest common subsequence between two strings.
     *
     * @param text1 The first input string
     * @param text2 The second input string
     * @return The length of the longest common subsequence
     * @throws NullPointerException if either text1 or text2 is null
     */
    public int longestCommonSubsequence(String text1, String text2) {
        if (text1 == null || text2 == null) {
            throw new NullPointerException("Input strings cannot be null");
        }

        int m = text1.length();
        int n = text2.length();

        // DP table where dp[i][j] represents the length of LCS of 
        // text1[0...i-1] and text2[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    /**
     * Test cases to verify the functionality of the LCS algorithm.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic test with common subsequence
        assert solution.longestCommonSubsequence("abcde", "ace") == 3 : "Test Case 1 Failed";

        // Test Case 2: No common subsequence
        assert solution.longestCommonSubsequence("abc", "def") == 0 : "Test Case 2 Failed";

        // Test Case 3: Identical strings
        assert solution.longestCommonSubsequence("abc", "abc") == 3 : "Test Case 3 Failed";

        // Test Case 4: Empty string
        assert solution.longestCommonSubsequence("", "abc") == 0 : "Test Case 4 Failed";

        // Test Case 5: Longer strings with multiple common subsequences
        assert solution.longestCommonSubsequence("AGGTAB", "GXTXAYB") == 4 : "Test Case 5 Failed";

        try {
            // Test Case 6: Null input
            solution.longestCommonSubsequence(null, "abc");
            assert false : "Test Case 6 Failed - Should throw NullPointerException";
        } catch (NullPointerException e) {
            // Expected behavior
        }

        System.out.println("All test cases passed!");
    }
}
