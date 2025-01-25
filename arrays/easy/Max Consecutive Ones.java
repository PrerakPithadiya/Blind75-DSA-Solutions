
/**
 * Solution class for finding maximum consecutive ones in a binary array.
 * Problem: Given a binary array nums, return the maximum number of consecutive 1's in the array.
 */
class Solution {

    /**
     * Finds the maximum number of consecutive ones in the given binary array.
     *
     * @param nums The input binary array containing only 0s and 1s
     * @return The length of the longest sequence of consecutive 1s
     * @throws IllegalArgumentException if the input array is null
     *
     * Time Complexity: O(n) where n is the length of the input array Space
     * Complexity: O(1) as we only use two variables regardless of input size
     *
     * Example 1: Input: nums = [1,1,0,1,1,1] Output: 3 Explanation: The longest
     * sequence of 1s is [1,1,1] with length 3
     *
     * Example 2: Input: nums = [1,0,1,1,0,1] Output: 2 Explanation: The longest
     * sequence of 1s is [1,1] with length 2
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        // Input validation
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }

        int maxCount = 0;
        int currentCount = 0;

        for (int num : nums) {
            if (num == 1) {
                currentCount++;
                maxCount = Math.max(maxCount, currentCount);
            } else if (num == 0) {
                currentCount = 0;
            } else {
                throw new IllegalArgumentException("Array should only contain 0s and 1s");
            }
        }

        return maxCount;
    }

    /**
     * Test cases to verify the functionality of findMaxConsecutiveOnes method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Regular case with consecutive ones
        assert solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}) == 3;

        // Test case 2: Array with no ones
        assert solution.findMaxConsecutiveOnes(new int[]{0, 0, 0}) == 0;

        // Test case 3: Array with no zeros
        assert solution.findMaxConsecutiveOnes(new int[]{1, 1, 1}) == 3;

        // Test case 4: Array with alternating ones and zeros
        assert solution.findMaxConsecutiveOnes(new int[]{1, 0, 1, 0, 1}) == 1;

        // Test case 5: Empty array
        assert solution.findMaxConsecutiveOnes(new int[]{}) == 0;

        // Test case 6: Array with single element
        assert solution.findMaxConsecutiveOnes(new int[]{1}) == 1;

        System.out.println("All test cases passed!");
    }
}
