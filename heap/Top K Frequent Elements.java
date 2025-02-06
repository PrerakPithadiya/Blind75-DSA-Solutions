
import java.util.*;

/**
 * Solution class for finding the k most frequent elements in an array. Time
 * Complexity: O(n log k) where n is the length of the input array Space
 * Complexity: O(n) for storing the frequency map
 */
class Solution {

    /**
     * Finds the k most frequent elements in the given array.
     *
     * @param nums The input array of integers
     * @param k The number of most frequent elements to return
     * @return An array containing the k most frequent elements
     * @throws IllegalArgumentException if k is greater than the number of
     * unique elements
     */
    public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            throw new IllegalArgumentException("Invalid input parameters");
        }

        // Step 1: Count the frequency of each element
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        if (k > frequencyMap.size()) {
            throw new IllegalArgumentException("k cannot be greater than the number of unique elements");
        }

        // Step 2: Use a priority queue (min heap) to keep the top k elements
        // The heap will maintain elements based on their frequency (smallest frequency at top)
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>(
                (a, b) -> b.getValue().compareTo(a.getValue())
        );

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            heap.add(entry);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 3: Extract the elements from the heap
        int[] result = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            result[i] = heap.poll().getKey();
        }

        return result;
    }

    /**
     * Test cases to verify the functionality of topKFrequent method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert Arrays.equals(solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2), new int[]{1, 2});

        // Test Case 2: All elements have same frequency
        assert Arrays.equals(solution.topKFrequent(new int[]{1, 2, 3}, 3), new int[]{1, 2, 3});

        // Test Case 3: Single element
        assert Arrays.equals(solution.topKFrequent(new int[]{1}, 1), new int[]{1});

        // Test Case 4: Elements with negative numbers
        assert Arrays.equals(solution.topKFrequent(new int[]{-1, -1, 2, 2, 2}, 2), new int[]{2, -1});

        try {
            // Test Case 5: Invalid k
            solution.topKFrequent(new int[]{1, 2}, 3);
            assert false : "Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All test cases passed!");
    }
}
