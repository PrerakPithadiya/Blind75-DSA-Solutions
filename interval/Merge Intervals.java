
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Solution class for merging overlapping intervals. Time Complexity: O(n log n)
 * where n is the number of intervals (due to sorting) Space Complexity: O(n) to
 * store the merged intervals
 */
class Solution {

    /**
     * Merges overlapping intervals into a single continuous interval.
     *
     * @param intervals 2D array where each element is an interval represented
     * by [start, end]
     * @return 2D array containing merged intervals with no overlaps
     *
     * Example 1: Input: intervals = [[1,3],[2,6],[8,10],[15,18]] Output:
     * [[1,6],[8,10],[15,18]] Explanation: Since intervals [1,3] and [2,6]
     * overlap, they are merged into [1,6]
     *
     * Example 2: Input: intervals = [[1,4],[4,5]] Output: [[1,5]] Explanation:
     * Intervals [1,4] and [4,5] are considered overlapping
     *
     * Example 3: Input: intervals = [[1,4],[0,4]] Output: [[0,4]] Explanation:
     * Overlapping intervals are merged into the interval with lowest start time
     */
    public int[][] merge(int[][] intervals) {
        // Edge case: if there are no intervals, return an empty array
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }

        // Sort intervals by the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        // Use a LinkedList to hold the merged intervals
        LinkedList<int[]> merged = new LinkedList<>();

        // Iterate over the intervals
        for (int[] interval : intervals) {
            // If the merged list is empty or there's no overlap with the last interval
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Otherwise, there's overlap, so merge the current interval with the last one
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }

        // Convert the LinkedList to an array and return
        // Using the more efficient way to convert to array
        return merged.toArray(new int[0][]);
    }

    /**
     * Test cases to verify the functionality of the merge method.
     */
    public void runTests() {
        // Test case 1: Normal overlapping intervals
        assert Arrays.deepEquals(
                merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}),
                new int[][]{{1, 6}, {8, 10}, {15, 18}}
        );

        // Test case 2: Intervals that touch
        assert Arrays.deepEquals(
                merge(new int[][]{{1, 4}, {4, 5}}),
                new int[][]{{1, 5}}
        );

        // Test case 3: No overlapping intervals
        assert Arrays.deepEquals(
                merge(new int[][]{{1, 2}, {3, 4}, {5, 6}}),
                new int[][]{{1, 2}, {3, 4}, {5, 6}}
        );

        // Test case 4: Single interval
        assert Arrays.deepEquals(
                merge(new int[][]{{1, 1}}),
                new int[][]{{1, 1}}
        );

        // Test case 5: Empty input
        assert Arrays.deepEquals(
                merge(new int[0][]),
                new int[0][]
        );

        // Test case 6: Completely overlapping intervals
        assert Arrays.deepEquals(
                merge(new int[][]{{1, 4}, {0, 4}}),
                new int[][]{{0, 4}}
        );

        System.out.println("All test cases passed!");
    }
}
