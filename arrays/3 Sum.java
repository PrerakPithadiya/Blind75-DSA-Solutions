
import java.util.*;

/**
 * Solution class for finding all unique triplets in an array that sum to zero.
 *
 * Problem: Given an integer array nums, find all unique triplets [nums[i],
 * nums[j], nums[k]] such that i != j, i != k, j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 *
 * Time Complexity: O(n^2) where n is the length of the input array Space
 * Complexity: O(1) excluding the space required for output
 */
class Solution {

    /**
     * Finds all unique triplets in the array that sum to zero.
     *
     * Algorithm: 1. Sort the array to handle duplicates and enable two-pointer
     * technique 2. Fix one number and use two pointers to find the other two
     * numbers 3. Skip duplicates to ensure unique triplets
     *
     * @param nums Input array of integers
     * @return List of all unique triplets that sum to zero
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        // Step 1: Sort the array
        Arrays.sort(nums);

        // Step 2: Iterate through the array to fix one number
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate values for nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;

            // Step 3: Two-pointer approach for the two-sum problem
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    // Skip duplicate values for nums[left] and nums[right]
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    // Move the pointers inward
                    left++;
                    right--;
                } else if (sum < target) {
                    left++; // Increase the sum
                } else {
                    right--; // Decrease the sum
                }
            }
        }

        return result;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Standard case with multiple solutions
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        System.out.println("Test Case 1: " + solution.threeSum(nums1));
        // Expected output: [[-1, -1, 2], [-1, 0, 1]]

        // Test Case 2: Array with all zeros
        int[] nums2 = {0, 0, 0, 0};
        System.out.println("Test Case 2: " + solution.threeSum(nums2));
        // Expected output: [[0, 0, 0]]

        // Test Case 3: Array with no solution
        int[] nums3 = {1, 2, 3, 4, 5};
        System.out.println("Test Case 3: " + solution.threeSum(nums3));
        // Expected output: []

        // Test Case 4: Array with negative numbers
        int[] nums4 = {-2, -2, -1, -1, 0, 1, 2, 2};
        System.out.println("Test Case 4: " + solution.threeSum(nums4));
        // Expected output: [[-2, 0, 2], [-1, -1, 2], [-1, 0, 1]]

        // Test Case 5: Empty array
        int[] nums5 = {};
        System.out.println("Test Case 5: " + solution.threeSum(nums5));
        // Expected output: []
    }
}
