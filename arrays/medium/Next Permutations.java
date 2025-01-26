
/**
 * Solution class for finding the next lexicographically greater permutation of an array.
 * Implements the algorithm to modify the array in-place to its next permutation.
 */
class Solution {

    /**
     * Finds the next lexicographically greater permutation of the given array.
     * Modifies the input array in-place to represent the next permutation. If
     * no greater permutation exists, it transforms the array to its lowest
     * possible permutation.
     *
     * Algorithm steps: 1. Find the first pair from right where nums[i] <
     * nums[i+1] 2. Find the smallest number greater than nums[i] from right 3.
     * Swap these numbers 4. Reverse the subarray after index i
     *
     * Time Complexity: O(n) Space Complexity: O(1)
     *
     * @param nums the input array to be modified to its next permutation
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    /**
     * Swaps two elements in the array at given indices.
     *
     * @param nums the array containing elements to swap
     * @param i index of first element
     * @param j index of second element
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Reverses a portion of the array starting from the given index to the end.
     *
     * @param nums the array to be partially reversed
     * @param start starting index from where reversal begins
     */
    private void reverse(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    /**
     * Test cases to verify the functionality of nextPermutation method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Regular case
        int[] test1 = {1, 2, 3};
        solution.nextPermutation(test1);
        assert java.util.Arrays.equals(test1, new int[]{1, 3, 2}) : "Test case 1 failed";

        // Test Case 2: Descending order
        int[] test2 = {3, 2, 1};
        solution.nextPermutation(test2);
        assert java.util.Arrays.equals(test2, new int[]{1, 2, 3}) : "Test case 2 failed";

        // Test Case 3: Duplicate elements
        int[] test3 = {1, 1, 5};
        solution.nextPermutation(test3);
        assert java.util.Arrays.equals(test3, new int[]{1, 5, 1}) : "Test case 3 failed";

        // Test Case 4: Single element
        int[] test4 = {1};
        solution.nextPermutation(test4);
        assert java.util.Arrays.equals(test4, new int[]{1}) : "Test case 4 failed";

        // Test Case 5: Empty array
        int[] test5 = {};
        solution.nextPermutation(test5);
        assert java.util.Arrays.equals(test5, new int[]{}) : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
