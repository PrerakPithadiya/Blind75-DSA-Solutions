
import java.util.*;

/**
 * Solution class for the Word Break problem Time Complexity: O(n^2 * m) where n
 * is length of string and m is average length of words in dictionary Space
 * Complexity: O(n) for the dp array
 */
class Solution {

    /**
     * Determines if a string can be segmented into words from the dictionary
     *
     * @param s The input string to be segmented
     * @param wordDict List of dictionary words
     * @return true if the string can be segmented into dictionary words, false
     * otherwise
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);  // Use a HashSet for fast lookup
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;  // Empty string can be segmented

        // For each position i in string
        for (int i = 1; i <= n; i++) {
            // Try all possible substrings ending at i
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;  // No need to check further if s[0:i] can be segmented
                }
            }
        }

        return dp[n];  // Final result for the entire string
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        String s1 = "leetcode";
        List<String> dict1 = Arrays.asList("leet", "code");
        System.out.println("Test 1: " + solution.wordBreak(s1, dict1));  // Expected: true

        // Test Case 2: Multiple segmentations possible
        String s2 = "applepenapple";
        List<String> dict2 = Arrays.asList("apple", "pen");
        System.out.println("Test 2: " + solution.wordBreak(s2, dict2));  // Expected: true

        // Test Case 3: Cannot be segmented
        String s3 = "catsandog";
        List<String> dict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println("Test 3: " + solution.wordBreak(s3, dict3));  // Expected: false

        // Test Case 4: Empty string
        String s4 = "";
        List<String> dict4 = Arrays.asList("test");
        System.out.println("Test 4: " + solution.wordBreak(s4, dict4));  // Expected: true

        // Test Case 5: Single character words
        String s5 = "ab";
        List<String> dict5 = Arrays.asList("a", "b");
        System.out.println("Test 5: " + solution.wordBreak(s5, dict5));  // Expected: true
    }
}
