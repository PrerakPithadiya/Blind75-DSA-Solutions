
/**
 * Solution class for moving zeros to the end of an array while maintaining relative order of non-zero elements.
 * LeetCode Problem: Move Zeros
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(1) as we modify the array in-place
 */
class Solution {

    /**
     * Moves all zeros in the array to the end while maintaining the relative
     * order of non-zero elements.
     *
     * @param nums The input array to be modified Example: Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int lastNonZeroFoundAt = 0;

        // Move all the non-zero elements to the beginning of the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt++] = nums[i];
            }
        }

        // Fill the remaining elements with 0
        for (int i = lastNonZeroFoundAt; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    /**
     * Test cases to verify the functionality of moveZeroes method
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array with zeros in between
        int[] test1 = {0, 1, 0, 3, 12};
        solution.moveZeroes(test1);
        assert java.util.Arrays.equals(test1, new int[]{1, 3, 12, 0, 0}) : "Test case 1 failed";

        // Test Case 2: Array with all zeros
        int[] test2 = {0, 0, 0};
        solution.moveZeroes(test2);
        assert java.util.Arrays.equals(test2, new int[]{0, 0, 0}) : "Test case 2 failed";

        // Test Case 3: Array with no zeros
        int[] test3 = {1, 2, 3};
        solution.moveZeroes(test3);
        assert java.util.Arrays.equals(test3, new int[]{1, 2, 3}) : "Test case 3 failed";

        // Test Case 4: Empty array
        int[] test4 = {};
        solution.moveZeroes(test4);
        assert java.util.Arrays.equals(test4, new int[]{}) : "Test case 4 failed";

        // Test Case 5: Array with single element
        int[] test5 = {0};
        solution.moveZeroes(test5);
        assert java.util.Arrays.equals(test5, new int[]{0}) : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
