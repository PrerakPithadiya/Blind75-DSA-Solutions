
/**
 * Solution class for counting palindromic substrings in a given string.
 * LeetCode Problem 647: Palindromic Substrings
 * Time Complexity: O(n^2) where n is the length of the input string
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Counts the total number of palindromic substrings in the given string. A
     * palindromic substring reads the same forwards and backwards.
     *
     * @param s the input string to check for palindromic substrings
     * @return the total count of palindromic substrings
     * @throws NullPointerException if the input string is null
     */
    public int countSubstrings(String s) {
        if (s == null) {
            throw new NullPointerException("Input string cannot be null");
        }

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += expandAroundCenter(s, i, i);     // odd length palindromes
            count += expandAroundCenter(s, i, i + 1); // even length palindromes
        }
        return count;
    }

    /**
     * Helper method that expands around a center point to find palindromes.
     * Checks characters on both sides of the center(s) for equality.
     *
     * @param s the input string
     * @param left the left pointer for expansion
     * @param right the right pointer for expansion
     * @return count of palindromes found while expanding from this center
     */
    private int expandAroundCenter(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Basic palindrome
        assert solution.countSubstrings("abc") == 3;  // "a", "b", "c"

        // Test case 2: String with multiple palindromes
        assert solution.countSubstrings("aaa") == 6;  // "a", "a", "a", "aa", "aa", "aaa"

        // Test case 3: Empty string
        assert solution.countSubstrings("") == 0;

        // Test case 4: String with even length palindromes
        assert solution.countSubstrings("abba") == 6;  // "a", "b", "b", "a", "bb", "abba"

        // Test case 5: String with mixed palindromes
        assert solution.countSubstrings("racecar") == 10;

        System.out.println("All test cases passed!");
    }
}
