
/**
 * Solution class for the Jump Game problem.
 * This class determines if it's possible to reach the last index in an array
 * where each element represents the maximum jump length at that position.
 */
class Solution {

    /**
     * Determines if it's possible to reach the last index of the array.
     *
     * @param nums An array of non-negative integers where nums[i] represents
     * the maximum jump length at index i
     * @return true if the last index can be reached, false otherwise
     * @throws IllegalArgumentException if the input array is null
     *
     * Time Complexity: O(n) where n is the length of the input array Space
     * Complexity: O(1) as we only use constant extra space
     */
    public boolean canJump(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int farthest = 0; // Initialize the farthest position we can reach

        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) {
                // If current index is greater than the farthest reachable point, return false
                return false;
            }
            // Update the farthest point we can reach
            farthest = Math.max(farthest, i + nums[i]);

            // If farthest point is greater than or equal to the last index, return true
            if (farthest >= nums.length - 1) {
                return true;
            }
        }

        // If we finish the loop, return false (in case we never reach the last index)
        return false;
    }

    /**
     * Test cases to verify the functionality of the canJump method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case where we can reach the end
        assert solution.canJump(new int[]{2, 3, 1, 1, 4}) == true;

        // Test Case 2: Cannot reach the end
        assert solution.canJump(new int[]{3, 2, 1, 0, 4}) == false;

        // Test Case 3: Single element array
        assert solution.canJump(new int[]{0}) == true;

        // Test Case 4: Array with all zeros except first element
        assert solution.canJump(new int[]{2, 0, 0}) == true;

        // Test Case 5: Array with all zeros
        assert solution.canJump(new int[]{0, 0, 0}) == false;

        // Test Case 6: Minimum jumps needed
        assert solution.canJump(new int[]{1, 1, 1, 1}) == true;

        // Test Case 7: Maximum possible jumps
        assert solution.canJump(new int[]{5, 9, 3, 2, 1, 0, 2, 3, 3, 1, 0, 0}) == true;

        try {
            solution.canJump(null);
            assert false : "Should throw IllegalArgumentException for null input";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All test cases passed!");
    }
}
