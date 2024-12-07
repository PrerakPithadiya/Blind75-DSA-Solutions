
/**
 * Solution for searching in a rotated sorted array.
 *
 * Problem Description:
 * Given a sorted array that has been rotated at some pivot point and a target value,
 * return the index of the target value if found in the array, or -1 if not found.
 * A rotated sorted array is an array that has been rotated at some pivot point.
 * Example: Original array: [1,2,3,4,5,6,7] -> Rotated array: [4,5,6,7,1,2,3]
 *
 * Algorithm:
 * 1. Uses modified binary search to handle the rotation
 * 2. First determines which half of the array is properly sorted
 * 3. Then checks if target lies in the sorted portion
 * 4. If yes, search in that portion; if no, search in the other portion
 *
 * Time Complexity: O(log n) where n is the length of the array
 * Space Complexity: O(1) as only constant extra space is used
 */
class Solution {

    /**
     * Searches for target value in a rotated sorted array.
     *
     * @param nums the input array that is sorted and rotated
     * @param target the value to search for
     * @return the index of target if found, -1 otherwise
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // Determine which side is properly sorted
            if (nums[left] <= nums[mid]) { // Left side is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right side is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }

        return -1;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal rotated array
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        assert solution.search(nums1, 0) == 4 : "Test case 1 failed";

        // Test Case 2: Target not found
        assert solution.search(nums1, 3) == -1 : "Test case 2 failed";

        // Test Case 3: Array with single element
        int[] nums2 = {1};
        assert solution.search(nums2, 1) == 0 : "Test case 3 failed";

        // Test Case 4: Empty array
        int[] nums3 = {};
        assert solution.search(nums3, 5) == -1 : "Test case 4 failed";

        // Test Case 5: Array not rotated
        int[] nums4 = {1, 2, 3, 4, 5};
        assert solution.search(nums4, 3) == 2 : "Test case 5 failed";

        // Test Case 6: Array rotated n times (back to original)
        int[] nums5 = {1, 2, 3, 4, 5};
        assert solution.search(nums5, 1) == 0 : "Test case 6 failed";

        System.out.println("All test cases passed!");
    }
}
