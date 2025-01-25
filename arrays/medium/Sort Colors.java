
/**
 * Solution for the Sort Colors problem (Dutch National Flag problem)
 *
 * Problem Description:
 * Given an array nums with n objects colored red, white, or blue, sort them in-place
 * so that objects of the same color are adjacent, with the colors in the order red,
 * white, and blue. We will use the integers 0, 1, and 2 to represent the color red,
 * white, and blue, respectively.
 *
 * Approach:
 * - Uses the Dutch National Flag algorithm (three-way partitioning)
 * - Maintains three pointers: low, mid, and high
 * - low: boundary of 0s (red)
 * - mid: current element being examined
 * - high: boundary of 2s (blue)
 *
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(1) as it sorts in-place
 */
class Solution {

    /**
     * Sorts an array containing only 0s, 1s, and 2s in-place.
     *
     * @param nums the input array to be sorted
     */
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;

        while (mid <= high) {
            switch (nums[mid]) {
                case 0 -> {
                    // Swap nums[low] and nums[mid]
                    int temp0 = nums[low];
                    nums[low] = nums[mid];
                    nums[mid] = temp0;
                    low++;
                    mid++;
                }
                case 1 ->
                    mid++;
                case 2 -> {
                    // Swap nums[mid] and nums[high]
                    int temp2 = nums[mid];
                    nums[mid] = nums[high];
                    nums[high] = temp2;
                    high--;
                }
            }
        }
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case with all colors
        int[] test1 = {2, 0, 2, 1, 1, 0};
        solution.sortColors(test1);
        assert java.util.Arrays.equals(test1, new int[]{0, 0, 1, 1, 2, 2}) : "Test case 1 failed";

        // Test Case 2: Already sorted array
        int[] test2 = {0, 0, 1, 1, 2, 2};
        solution.sortColors(test2);
        assert java.util.Arrays.equals(test2, new int[]{0, 0, 1, 1, 2, 2}) : "Test case 2 failed";

        // Test Case 3: Reverse sorted array
        int[] test3 = {2, 2, 1, 1, 0, 0};
        solution.sortColors(test3);
        assert java.util.Arrays.equals(test3, new int[]{0, 0, 1, 1, 2, 2}) : "Test case 3 failed";

        // Test Case 4: Array with single element
        int[] test4 = {1};
        solution.sortColors(test4);
        assert java.util.Arrays.equals(test4, new int[]{1}) : "Test case 4 failed";

        // Test Case 5: Empty array
        int[] test5 = {};
        solution.sortColors(test5);
        assert java.util.Arrays.equals(test5, new int[]{}) : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
