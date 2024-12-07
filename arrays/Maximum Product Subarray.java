
/**
 * Solution for Maximum Product Subarray problem.
 *
 * Problem Description:
 * Given an integer array nums, find a contiguous non-empty subarray within the array
 * that has the largest product, and return the product.
 *
 * Approach:
 * 1. Use Kadane's algorithm variant to keep track of both maximum and minimum products
 * 2. Need to track minimum product because multiplying a negative number with a negative
 *    could give us maximum product
 * 3. When encountering a negative number, swap max and min products
 *
 * Time Complexity: O(n) where n is the length of input array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the contiguous subarray with the largest product.
     *
     * @param nums Input array of integers
     * @return The maximum product of any contiguous subarray within nums
     * @throws IllegalArgumentException if the input array is null or empty
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        // Initialize the variables to track maximum and minimum products
        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0]; // Global maximum product

        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            int current = nums[i];

            // If the current number is negative, swap maxProd and minProd
            if (current < 0) {
                int temp = maxProd;
                maxProd = minProd;
                minProd = temp;
            }

            // Update maxProd and minProd considering the current number
            maxProd = Math.max(current, maxProd * current);
            minProd = Math.min(current, minProd * current);

            // Update the global maximum product
            result = Math.max(result, maxProd);
        }

        return result;
    }

    /**
     * Test cases for the maxProduct method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic positive numbers
        assert solution.maxProduct(new int[]{2, 3, -2, 4}) == 6 : "Test case 1 failed";

        // Test Case 2: Array with negative numbers
        assert solution.maxProduct(new int[]{-2, 0, -1}) == 0 : "Test case 2 failed";

        // Test Case 3: All positive numbers
        assert solution.maxProduct(new int[]{1, 2, 3, 4}) == 24 : "Test case 3 failed";

        // Test Case 4: Multiple negative numbers
        assert solution.maxProduct(new int[]{-2, 3, -4}) == 24 : "Test case 4 failed";

        // Test Case 5: Single element array
        assert solution.maxProduct(new int[]{5}) == 5 : "Test case 5 failed";

        // Test Case 6: Array with zeros
        assert solution.maxProduct(new int[]{-2, 0, -1, 0, 3}) == 3 : "Test case 6 failed";

        // Test Case 7: All negative numbers
        assert solution.maxProduct(new int[]{-1, -2, -3, -4}) == 24 : "Test case 7 failed";

        System.out.println("All test cases passed!");
    }
}
