
/**
 * Solution for finding a single number in an array where all other numbers appear twice.
 *
 * Problem:
 * Given a non-empty array of integers where every element appears twice except for one,
 * find that single element.
 *
 * Approach:
 * - Uses XOR operation properties:
 *   1. a XOR a = 0 (number XOR with itself gives 0)
 *   2. a XOR 0 = a (number XOR with 0 gives the number itself)
 *   3. XOR is associative and commutative
 * - Time Complexity: O(n) where n is the length of input array
 * - Space Complexity: O(1) as we only use one variable
 */
class Solution {

    /**
     * Finds the single number in an array where all other numbers appear twice.
     *
     * @param nums Input array of integers where one element appears once and
     * others appear twice
     * @return The element that appears only once
     * @throws IllegalArgumentException if input array is null or empty
     */
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Input array cannot be null or empty");
        }

        int result = 0;
        for (int num : nums) {
            result ^= num; // Apply XOR to each element
        }
        return result; // The result will be the single number
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        assert solution.singleNumber(new int[]{2, 2, 1}) == 1 : "Test Case 1 Failed";

        // Test Case 2: Single element appears in middle
        assert solution.singleNumber(new int[]{4, 1, 2, 1, 2}) == 4 : "Test Case 2 Failed";

        // Test Case 3: Larger numbers
        assert solution.singleNumber(new int[]{1, 3, 1, -1, 3}) == -1 : "Test Case 3 Failed";

        // Test Case 4: Single element array
        assert solution.singleNumber(new int[]{1}) == 1 : "Test Case 4 Failed";

        try {
            solution.singleNumber(null);
            assert false : "Should throw IllegalArgumentException for null input";
        } catch (IllegalArgumentException e) {
            // Expected behavior
        }

        System.out.println("All test cases passed!");
    }
}
