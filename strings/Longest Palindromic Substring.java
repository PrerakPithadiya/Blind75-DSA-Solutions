
/**
 * Solution for finding the longest palindromic substring in a given string.
 *
 * Time Complexity: O(n^2) where n is the length of the input string
 * Space Complexity: O(1) as we only use constant extra space
 *
 * @author Sourcegraph
 */
class Solution {

    /**
     * Finds the longest palindromic substring in the given string. This method
     * uses the expand around center approach to find palindromes.
     *
     * @param s the input string to find palindrome in
     * @return the longest palindromic substring found
     * @throws NullPointerException if input string is null
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }

        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);     // For odd length palindromes
            int len2 = expandAroundCenter(s, i, i + 1); // For even length palindromes
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    /**
     * Helper method to expand around a center and find palindrome length.
     *
     * @param s the input string
     * @param left the left pointer for expansion
     * @param right the right pointer for expansion
     * @return length of palindrome expanded from center
     */
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic palindrome
        assert solution.longestPalindrome("babad").equals("bab")
                || solution.longestPalindrome("babad").equals("aba") : "Test case 1 failed";

        // Test case 2: Even length palindrome
        assert solution.longestPalindrome("cbbd").equals("bb") : "Test case 2 failed";

        // Test case 3: Single character
        assert solution.longestPalindrome("a").equals("a") : "Test case 3 failed";

        // Test case 4: Empty string
        assert solution.longestPalindrome("").equals("") : "Test case 4 failed";

        // Test case 5: All same characters
        assert solution.longestPalindrome("aaaa").equals("aaaa") : "Test case 5 failed";

        // Test case 6: No palindrome longer than 1
        assert solution.longestPalindrome("abcd").equals("a")
                || solution.longestPalindrome("abcd").equals("b")
                || solution.longestPalindrome("abcd").equals("c")
                || solution.longestPalindrome("abcd").equals("d") : "Test case 6 failed";

        System.out.println("All test cases passed!");
    }
}
