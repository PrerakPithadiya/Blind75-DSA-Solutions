
/**
 * Solution class for removing duplicates from a sorted array.
 * Time Complexity: O(n) where n is the length of input array
 * Space Complexity: O(1) as we modify array in-place
 */
class Solution {

    /**
     * Removes duplicates from a sorted array in-place and returns the number of
     * unique elements. The first k elements of the modified array will contain
     * the unique elements in sorted order.
     *
     * @param nums the input sorted integer array
     * @return k - the number of unique elements in the array
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int k = 1; // Initialize the count of unique elements

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array with duplicates
        int[] nums1 = {1, 1, 2};
        int k1 = solution.removeDuplicates(nums1);
        assert k1 == 2 : "Test Case 1 Failed";
        assert nums1[0] == 1 && nums1[1] == 2 : "Test Case 1 Failed";

        // Test Case 2: Array with more duplicates
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int k2 = solution.removeDuplicates(nums2);
        assert k2 == 5 : "Test Case 2 Failed";
        assert nums2[0] == 0 && nums2[1] == 1 && nums2[2] == 2
                && nums2[3] == 3 && nums2[4] == 4 : "Test Case 2 Failed";

        // Test Case 3: Array with no duplicates
        int[] nums3 = {1, 2, 3};
        int k3 = solution.removeDuplicates(nums3);
        assert k3 == 3 : "Test Case 3 Failed";

        // Test Case 4: Empty array
        int[] nums4 = {};
        int k4 = solution.removeDuplicates(nums4);
        assert k4 == 0 : "Test Case 4 Failed";

        // Test Case 5: Array with single element
        int[] nums5 = {1};
        int k5 = solution.removeDuplicates(nums5);
        assert k5 == 1 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
