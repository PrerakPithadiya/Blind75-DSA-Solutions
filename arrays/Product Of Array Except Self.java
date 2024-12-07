
/**
 * Solution for Product of Array Except Self problem
 * Given an array nums, return an array answer such that answer[i] is equal to
 * the product of all elements of nums except nums[i].
 * Time Complexity: O(n)
 * Space Complexity: O(1) excluding the output array
 */
class Solution {

    /**
     * Calculates product of all elements except self without using division
     *
     * @param nums input array of integers
     * @return array where each element is product of all numbers except self
     */
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Step 1: Calculate prefix products
        answer[0] = 1; // The product of elements to the left of the first element is 1
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Step 2: Calculate suffix products and combine with prefix products
        int suffixProduct = 1; // The product of elements to the right of the last element is 1
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffixProduct; // Multiply with the suffix product
            suffixProduct *= nums[i]; // Update the suffix product
        }

        return answer;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] nums1 = {1, 2, 3, 4};
        int[] result1 = solution.productExceptSelf(nums1);
        assert java.util.Arrays.equals(result1, new int[]{24, 12, 8, 6});

        // Test Case 2: Array with zeros
        int[] nums2 = {0, 1, 2, 3};
        int[] result2 = solution.productExceptSelf(nums2);
        assert java.util.Arrays.equals(result2, new int[]{6, 0, 0, 0});

        // Test Case 3: Array with multiple zeros
        int[] nums3 = {0, 0, 2, 3};
        int[] result3 = solution.productExceptSelf(nums3);
        assert java.util.Arrays.equals(result3, new int[]{0, 0, 0, 0});

        // Test Case 4: Minimum length array
        int[] nums4 = {1, 1};
        int[] result4 = solution.productExceptSelf(nums4);
        assert java.util.Arrays.equals(result4, new int[]{1, 1});

        System.out.println("All test cases passed!");
    }
}
