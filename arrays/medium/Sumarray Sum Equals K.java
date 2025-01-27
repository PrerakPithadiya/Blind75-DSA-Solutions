
import java.util.HashMap;
import java.util.Map;

/**
 * Solution class for finding the number of subarrays with sum equal to k. Time
 * Complexity: O(n) where n is the length of the input array Space Complexity:
 * O(n) for storing prefix sums in the HashMap
 */
class Solution {

    /**
     * Finds the total number of continuous subarrays whose sum equals k.
     *
     * @param nums The input array of integers
     * @param k The target sum
     * @return The number of subarrays with sum equal to k
     *
     * Algorithm: 1. Use a HashMap to store prefix sums and their frequencies 2.
     * For each element, calculate current prefix sum 3. Check if
     * (currentPrefixSum - k) exists in map to find valid subarrays 4. Update
     * the map with current prefix sum
     *
     * Example: Input: nums = [1,1,1], k = 2 Output: 2 Explanation: Subarrays
     * [1,1] and [1,1] have sum = 2
     */
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // To handle cases where a subarray starts from index 0

        int currentPrefixSum = 0;
        int count = 0;

        for (int num : nums) {
            // Update the current prefix sum
            currentPrefixSum += num;

            // Check if there is a prefix sum that we can subtract to get k
            if (prefixSumCount.containsKey(currentPrefixSum - k)) {
                count += prefixSumCount.get(currentPrefixSum - k);
            }

            // Update the hash map with the current prefix sum
            prefixSumCount.put(currentPrefixSum, prefixSumCount.getOrDefault(currentPrefixSum, 0) + 1);
        }

        return count;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.subarraySum(new int[]{1, 1, 1}, 2) == 2 : "Test Case 1 Failed";

        // Test Case 2: Array with negative numbers
        assert solution.subarraySum(new int[]{1, -1, 0}, 0) == 3 : "Test Case 2 Failed";

        // Test Case 3: Empty array
        assert solution.subarraySum(new int[]{}, 5) == 0 : "Test Case 3 Failed";

        // Test Case 4: Single element array
        assert solution.subarraySum(new int[]{1}, 1) == 1 : "Test Case 4 Failed";

        // Test Case 5: No subarrays with sum k
        assert solution.subarraySum(new int[]{1, 2, 3}, 6) == 1 : "Test Case 5 Failed";

        // Test Case 6: Array with all zeros
        assert solution.subarraySum(new int[]{0, 0, 0}, 0) == 6 : "Test Case 6 Failed";

        System.out.println("All test cases passed!");
    }
}
