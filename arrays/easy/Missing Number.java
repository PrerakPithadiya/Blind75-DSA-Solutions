
/**
 * Solution class for finding the missing number in a sequence from 0 to n.
 */
class Solution {

    /**
     * Finds the missing number in an array containing n distinct numbers from 0
     * to n.
     *
     * Algorithm: 1. Calculate the expected sum of numbers from 0 to n using
     * arithmetic progression formula 2. Calculate the actual sum of numbers in
     * the input array 3. The difference between expected and actual sum is the
     * missing number
     *
     * Time Complexity: O(n) where n is the length of input array Space
     * Complexity: O(1) as we only use constant extra space
     *
     * @param nums array containing n distinct numbers from 0 to n (inclusive),
     * with one number missing
     * @return the missing number in the sequence
     * @throws IllegalArgumentException if input array is null
     */
    public int missingNumber(int[] nums) {
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;

        for (int num : nums) {
            actualSum += num;
        }

        return expectedSum - actualSum;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Missing number in middle
        assert solution.missingNumber(new int[]{3, 0, 1}) == 2 : "Test case 1 failed";

        // Test case 2: Missing number at end
        assert solution.missingNumber(new int[]{0, 1}) == 2 : "Test case 2 failed";

        // Test case 3: Missing number at start
        assert solution.missingNumber(new int[]{1, 2}) == 0 : "Test case 3 failed";

        // Test case 4: Single element array
        assert solution.missingNumber(new int[]{0}) == 1 : "Test case 4 failed";

        // Test case 5: Larger array
        assert solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}) == 8 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
