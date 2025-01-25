
/**
 * Solution class for checking if an array is sorted and rotated
 * Time Complexity: O(n) where n is length of array
 * Space Complexity: O(1)
 */
class Solution {

    /**
     * Checks if array is sorted and rotated by counting number of
     * irregularities An array is considered sorted and rotated if after
     * rotating it at some pivot, it becomes sorted in ascending order
     *
     * @param nums Input integer array to check
     * @return true if array is sorted and rotated, false otherwise
     */
    public boolean check(int[] nums) {
        int count = 0;
        int n = nums.length;

        // Count number of times current element is greater than next element
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }

        // If count <= 1, array is sorted and rotated
        return count <= 1;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Sorted and rotated array
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Test Case 1: " + solution.check(nums1)); // Expected: true

        // Test Case 2: Sorted array
        int[] nums2 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 2: " + solution.check(nums2)); // Expected: true

        // Test Case 3: Not sorted or rotated array
        int[] nums3 = {2, 1, 3, 4};
        System.out.println("Test Case 3: " + solution.check(nums3)); // Expected: false

        // Test Case 4: Array with duplicate elements
        int[] nums4 = {1, 1, 1};
        System.out.println("Test Case 4: " + solution.check(nums4)); // Expected: true

        // Test Case 5: Two element array
        int[] nums5 = {2, 1};
        System.out.println("Test Case 5: " + solution.check(nums5)); // Expected: true
    }
}
