
/**
 * Solution class for rotating an array to the right by k steps.
 * Time Complexity: O(n) where n is the length of the array
 * Space Complexity: O(1) as we perform the rotation in-place
 */
class Solution {

    /**
     * Rotates the elements of the array to the right by k steps. The rotation
     * is performed using the reversal algorithm which consists of three steps:
     * 1. Reverse the entire array 2. Reverse the first k elements 3. Reverse
     * the remaining elements
     *
     * @param nums the input array to be rotated
     * @param k the number of positions to rotate right
     *
     * Example 1: Input: nums = [1,2,3,4,5,6,7], k = 3 Output: [5,6,7,1,2,3,4]
     * Explanation: - Original array: [1,2,3,4,5,6,7] - After first reverse:
     * [7,6,5,4,3,2,1] - After reversing first k elements: [5,6,7,4,3,2,1] -
     * After reversing remaining elements: [5,6,7,1,2,3,4]
     *
     * Example 2: Input: nums = [-1,-100,3,99], k = 2 Output: [3,99,-1,-100]
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Ensure k is within bounds of the array's length
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    /**
     * Helper function to reverse a portion of the array between start and end
     * indices. The reversal is done in-place by swapping elements from both
     * ends until the middle is reached.
     *
     * @param nums the array containing elements to be reversed
     * @param start the starting index of the portion to be reversed
     * @param end the ending index of the portion to be reversed
     *
     * Example: For array [1,2,3,4,5] with start=0 and end=4 After reverse:
     * [5,4,3,2,1]
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Test cases to verify the rotation functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard rotation
        int[] test1 = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(test1, 3);
        assert java.util.Arrays.equals(test1, new int[]{5, 6, 7, 1, 2, 3, 4});

        // Test Case 2: Rotation with negative numbers
        int[] test2 = {-1, -100, 3, 99};
        solution.rotate(test2, 2);
        assert java.util.Arrays.equals(test2, new int[]{3, 99, -1, -100});

        // Test Case 3: Rotation with k > array length
        int[] test3 = {1, 2, 3};
        solution.rotate(test3, 4);
        assert java.util.Arrays.equals(test3, new int[]{3, 1, 2});

        // Test Case 4: Empty array
        int[] test4 = {};
        solution.rotate(test4, 1);
        assert java.util.Arrays.equals(test4, new int[]{});

        // Test Case 5: Single element array
        int[] test5 = {1};
        solution.rotate(test5, 1);
        assert java.util.Arrays.equals(test5, new int[]{1});

        System.out.println("All test cases passed!");
    }
}
