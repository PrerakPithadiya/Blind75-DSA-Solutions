
import java.util.Arrays;

/**
 * Solution class for handling interval overlap problems. This class provides
 * functionality to find the minimum number of intervals that need to be removed
 * to make the remaining intervals non-overlapping.
 */
class Solution {

    /**
     * Calculates the minimum number of intervals that must be removed to make
     * the remaining intervals non-overlapping.
     *
     * @param intervals A 2D array where each inner array represents an interval
     * with start time at index 0 and end time at index 1
     * @return The minimum number of intervals that must be removed
     *
     * Algorithm: 1. If the input array is empty, return 0 2. Sort intervals by
     * their end time to optimize the greedy approach 3. Iterate through sorted
     * intervals, counting overlaps 4. For each overlap found, increment counter
     * (representing an interval that must be removed)
     *
     * Time Complexity: O(n log n) due to sorting Space Complexity: O(1) as we
     * only use constant extra space
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort intervals by their end time
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < lastEnd) {
                // Overlapping interval, must remove one
                count++;
            } else {
                // No overlap, update the end time
                lastEnd = intervals[i][1];
            }
        }

        return count;
    }

    /**
     * Test cases to verify the functionality of eraseOverlapIntervals method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic overlapping intervals
        int[][] test1 = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        assert solution.eraseOverlapIntervals(test1) == 1 : "Test Case 1 Failed";

        // Test Case 2: No overlapping intervals
        int[][] test2 = {{1, 2}, {2, 3}, {3, 4}};
        assert solution.eraseOverlapIntervals(test2) == 0 : "Test Case 2 Failed";

        // Test Case 3: All intervals overlap
        int[][] test3 = {{1, 2}, {1, 2}, {1, 2}};
        assert solution.eraseOverlapIntervals(test3) == 2 : "Test Case 3 Failed";

        // Test Case 4: Empty array
        int[][] test4 = {};
        assert solution.eraseOverlapIntervals(test4) == 0 : "Test Case 4 Failed";

        // Test Case 5: Null input
        int[][] test5 = null;
        assert solution.eraseOverlapIntervals(test5) == 0 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
