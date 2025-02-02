
import java.util.ArrayList;
import java.util.List;

/**
 * Solution class for merging and inserting intervals. Time Complexity: O(n)
 * where n is the length of intervals array Space Complexity: O(n) to store the
 * result
 */
class Solution {

    /**
     * Inserts a new interval into a sorted array of non-overlapping intervals
     * and merges if necessary.
     *
     * @param intervals Sorted array of non-overlapping intervals where each
     * interval is [start, end]
     * @param newInterval New interval to be inserted
     * @return Array of merged intervals after insertion
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // Input validation
        if (intervals == null || newInterval == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before newInterval
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval);

        // Add remaining intervals that come after newInterval
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        // Convert result list to array more efficiently
        return result.toArray(new int[0][]);
    }

    /**
     * Test cases to verify the functionality of insert method
     */
    public void runTests() {
        // Test Case 1: Normal case with overlapping intervals
        assert java.util.Arrays.deepEquals(
                insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5}),
                new int[][]{{1, 5}, {6, 9}}
        );

        // Test Case 2: New interval comes before all existing intervals
        assert java.util.Arrays.deepEquals(
                insert(new int[][]{{1, 3}, {6, 9}}, new int[]{0, 0}),
                new int[][]{{0, 0}, {1, 3}, {6, 9}}
        );

        // Test Case 3: New interval comes after all existing intervals
        assert java.util.Arrays.deepEquals(
                insert(new int[][]{{1, 3}, {6, 9}}, new int[]{10, 11}),
                new int[][]{{1, 3}, {6, 9}, {10, 11}}
        );

        // Test Case 4: New interval merges all existing intervals
        assert java.util.Arrays.deepEquals(
                insert(new int[][]{{1, 3}, {4, 6}, {8, 10}}, new int[]{2, 9}),
                new int[][]{{1, 10}}
        );

        // Test Case 5: Empty intervals array
        assert java.util.Arrays.deepEquals(
                insert(new int[][]{}, new int[]{5, 7}),
                new int[][]{{5, 7}}
        );

        System.out.println("All test cases passed!");
    }
}
