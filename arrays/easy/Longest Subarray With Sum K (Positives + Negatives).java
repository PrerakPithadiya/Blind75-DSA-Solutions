
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class for finding the longest subarray with a given sum k. This
 * implementation works for arrays containing both positive and negative
 * integers.
 *
 * Problem Description: Given an array of integers (both positive and negative)
 * and a target sum k, find the length of the longest subarray whose sum equals
 * k.
 *
 * Example: Input: arr = [1, 2, 3, -3, 1, 1, 1, 4, 2, -3], k = 3 Output: 4
 * Explanation: The subarray [1, 1, 1, 0] has sum = 3 and length = 4
 */
class Solution {

    /**
     * Finds the length of the longest subarray with sum equal to k.
     *
     * @param arr The input array of integers (can contain positive and negative
     * numbers)
     * @param k The target sum to find in subarrays
     * @return The length of the longest subarray with sum equal to k
     *
     * Time Complexity: O(n) where n is the length of the input array Space
     * Complexity: O(n) to store the prefix sums in the HashMap
     *
     * Algorithm: 1. Use prefix sum technique to track running sum of elements
     * 2. Use HashMap to store prefix sums and their indices 3. For each prefix
     * sum, check if (prefixSum - k) exists in map 4. Update maxLength when a
     * valid subarray is found
     *
     * Edge Cases Handled: - Empty array - Single element array - Array with all
     * zeros - Array with all positive numbers - Array with all negative numbers
     * - Array with mixed positive and negative numbers
     */
    public int longestSubarray(int[] arr, int k) {
        // HashMap to store the first occurrence of each prefix sum
        Map<Integer, Integer> prefixSumMap = new HashMap<>();

        int prefixSum = 0; // Tracks the running prefix sum
        int maxLength = 0; // Tracks the length of the longest subarray with sum k

        for (int i = 0; i < arr.length; i++) {
            prefixSum += arr[i];

            // Case 1: Check if the prefix sum equals k
            if (prefixSum == k) {
                maxLength = i + 1; // Entire array from 0 to i has sum k
            }

            // Case 2: Check if the difference (prefixSum - k) exists in the map
            if (prefixSumMap.containsKey(prefixSum - k)) {
                int subarrayLength = i - prefixSumMap.get(prefixSum - k);
                maxLength = Math.max(maxLength, subarrayLength);
            }

            // Case 3: Store the prefix sum in the map if it's not already present
            if (!prefixSumMap.containsKey(prefixSum)) {
                prefixSumMap.put(prefixSum, i);
            }
        }

        return maxLength; // Return the length of the longest subarray
    }

    /**
     * Test cases to verify the implementation. Covers various scenarios
     * including edge cases and common use cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic positive numbers
        assert solution.longestSubarray(new int[]{1, 2, 3, 4}, 6) == 3; // [1, 2, 3]

        // Test Case 2: Array with negative numbers
        assert solution.longestSubarray(new int[]{-1, 2, -3, 4, 5}, 3) == 4; // [2, -3, 4]

        // Test Case 3: Multiple valid subarrays
        assert solution.longestSubarray(new int[]{1, 1, 1}, 2) == 2; // [1, 1]

        // Test Case 4: No valid subarray
        assert solution.longestSubarray(new int[]{1, 2, 3}, 10) == 0;

        // Test Case 5: Single element equal to k
        assert solution.longestSubarray(new int[]{5}, 5) == 1;

        // Test Case 6: Zero sum subarray
        assert solution.longestSubarray(new int[]{1, -1, 0}, 0) == 2; // [1, -1] or [-1, 0]

        // Test Case 7: Empty array
        assert solution.longestSubarray(new int[]{}, 5) == 0;

        // Test Case 8: All zeros
        assert solution.longestSubarray(new int[]{0, 0, 0, 0}, 0) == 4;

        // Test Case 9: Complex case with multiple valid subarrays
        assert solution.longestSubarray(new int[]{1, 2, 3, -3, 1, 1, 1, 4, 2, -3}, 3) == 4;

        // Test Case 10: Negative target sum
        assert solution.longestSubarray(new int[]{1, -2, 3, -4, 5}, -3) == 2; // [-2, -1]

        // Test Case 11: Large numbers
        assert solution.longestSubarray(new int[]{1000, -1000, 1000, -1000}, 0) == 4;

        // Test Case 12: Alternating positive and negative numbers
        assert solution.longestSubarray(new int[]{1, -1, 1, -1, 1, -1}, 0) == 6;

        System.out.println("All test cases passed!");
    }
}
