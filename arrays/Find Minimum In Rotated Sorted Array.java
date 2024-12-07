
/**
 * Solution for finding the minimum element in a rotated sorted array.
 *
 * Problem Description:
 * Given a sorted array that has been rotated between 1 and n times, find the minimum element.
 * The array was originally sorted in ascending order before being rotated.
 *
 * Algorithm:
 * - Uses modified binary search to find the minimum element
 * - Compares middle element with rightmost element to determine which half contains the minimum
 * - Time Complexity: O(log n) where n is the length of the array
 * - Space Complexity: O(1) as only constant extra space is used
 *
 * Example:
 * Input: [3,4,5,1,2] (original array [1,2,3,4,5] rotated 3 times)
 * Output: 1
 *
 * Input: [4,5,6,7,0,1,2] (original array [0,1,2,4,5,6,7] rotated 4 times)
 * Output: 0
 */
class Solution {

    /**
     * Finds the minimum element in a rotated sorted array.
     *
     * @param nums the input array that was originally sorted and then rotated
     * @return the minimum element in the array
     */
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            // If the middle element is greater than the right element, the minimum is in the right half.
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } // Otherwise, the minimum is in the left half or could be the mid itself.
            else {
                right = mid;
            }
        }

        // When left == right, we've found the minimum element.
        return nums[left];
    }

    /**
     * Test cases to verify the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array rotated 3 times
        int[] test1 = {3, 4, 5, 1, 2};
        assert solution.findMin(test1) == 1 : "Test Case 1 Failed";

        // Test Case 2: Array rotated 4 times
        int[] test2 = {4, 5, 6, 7, 0, 1, 2};
        assert solution.findMin(test2) == 0 : "Test Case 2 Failed";

        // Test Case 3: Array not rotated
        int[] test3 = {1, 2, 3, 4, 5};
        assert solution.findMin(test3) == 1 : "Test Case 3 Failed";

        // Test Case 4: Array with two elements
        int[] test4 = {2, 1};
        assert solution.findMin(test4) == 1 : "Test Case 4 Failed";

        // Test Case 5: Array with one element
        int[] test5 = {1};
        assert solution.findMin(test5) == 1 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
