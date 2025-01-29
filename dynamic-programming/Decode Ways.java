
/**
 * Problem: Decode Ways
 *
 * Description:
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * 'A' -> "1"
 * 'B' -> "2"
 * ...
 * 'Z' -> "26"
 *
 * Given a string containing only digits, return the number of ways to decode it.
 *
 * Approach:
 * - Use dynamic programming where dp[i] represents number of ways to decode string up to index i
 * - For each position, we check if:
 *   1. Single digit (1-9) is valid -> add dp[i-1] ways
 *   2. Two digits (10-26) is valid -> add dp[i-2] ways
 *
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) for the dp array
 */
class Solution {

    /**
     * Calculates the number of possible ways to decode a string of digits.
     *
     * @param s The input string containing only digits
     * @return The number of possible decodings
     */
    public int numDecodings(String s) {
        // Handle edge cases
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int n = s.length();
        // dp[i] represents number of ways to decode string up to index i
        int[] dp = new int[n + 1];

        // Empty string has 1 way to decode
        dp[0] = 1;

        // Initialize first character
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        try {
            for (int i = 2; i <= n; i++) {
                // Get single digit and two digits number
                int oneDigit = Integer.parseInt(s.substring(i - 1, i));
                int twoDigits = Integer.parseInt(s.substring(i - 2, i));

                // If single digit is valid (1-9)
                if (oneDigit >= 1) {
                    dp[i] += dp[i - 1];
                }

                // If two digits is valid (10-26)
                if (twoDigits >= 10 && twoDigits <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        } catch (NumberFormatException e) {
            return 0; // Handle invalid input containing non-digit characters
        }

        return dp[n];
    }

    /**
     * Test cases for the numDecodings method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic valid input
        assert solution.numDecodings("12") == 2;  // Can be decoded as "AB" (1 2) or "L" (12)

        // Test case 2: Input with zero
        assert solution.numDecodings("106") == 1;  // Can only be decoded as "JF" (10 6)

        // Test case 3: Invalid input starting with zero
        assert solution.numDecodings("0") == 0;

        // Test case 4: Complex valid input
        assert solution.numDecodings("226") == 3;  // Can be decoded as "BBF" (2 2 6), "BZ" (2 26), or "VF" (22 6)

        // Test case 5: Invalid sequence
        assert solution.numDecodings("27") == 1;  // Can only be decoded as "BG" (2 7)

        // Test case 6: Empty string
        assert solution.numDecodings("") == 0;

        // Test case 7: Null input
        assert solution.numDecodings(null) == 0;

        System.out.println("All test cases passed!");
    }
}
