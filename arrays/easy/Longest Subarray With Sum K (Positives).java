
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class for finding the longest subarray with sum K in an array of
 * positive integers.
 */
class Solution {

    /**
     * Finds the length of the longest subarray with sum equal to K.
     *
     * Time Complexity: O(n) where n is the length of the input array Space
     * Complexity: O(n) to store the prefix sums in the HashMap
     *
     * @param arr The input array of positive integers
     * @param k The target sum
     * @return The length of the longest subarray with sum equal to k
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

        return maxLength;
    }

    /**
     * Test cases to verify the functionality of longestSubarray method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] arr1 = {1, 2, 3, 1, 1, 1, 1};
        int k1 = 3;
        assert solution.longestSubarray(arr1, k1) == 3 : "Test Case 1 Failed";

        // Test Case 2: No subarray exists
        int[] arr2 = {1, 2, 3, 4};
        int k2 = 10;
        assert solution.longestSubarray(arr2, k2) == 0 : "Test Case 2 Failed";

        // Test Case 3: Entire array sums to k
        int[] arr3 = {1, 1, 1};
        int k3 = 3;
        assert solution.longestSubarray(arr3, k3) == 3 : "Test Case 3 Failed";

        // Test Case 4: Multiple valid subarrays
        int[] arr4 = {1, 2, 1, 3, 2, 1, 1, 1};
        int k4 = 3;
        assert solution.longestSubarray(arr4, k4) == 3 : "Test Case 4 Failed";

        // Test Case 5: Single element equal to k
        int[] arr5 = {5, 2, 3, 4};
        int k5 = 5;
        assert solution.longestSubarray(arr5, k5) == 1 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
