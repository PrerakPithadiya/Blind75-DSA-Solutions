
/**
 * Solution class for finding the majority element in an array.
 * Uses Boyer-Moore Voting Algorithm with O(n) time complexity and O(1) space complexity.
 */
class Solution {

    /**
     * Finds the majority element in an array of integers. A majority element
     * appears more than n/2 times in the array where n is array length.
     *
     * @param nums the input array of integers
     * @return the majority element that appears more than n/2 times
     *
     * Time Complexity: O(n) where n is the length of input array Space
     * Complexity: O(1) as only constant extra space is used
     *
     * Example 1: Input: nums = [3,2,3] Output: 3
     *
     * Example 2: Input: nums = [2,2,1,1,1,2,2] Output: 2
     *
     * Example 3: Input: nums = [1] Output: 1
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Simple majority element
        int[] test1 = {3, 2, 3};
        assert solution.majorityElement(test1) == 3;

        // Test case 2: Multiple occurrences of majority element
        int[] test2 = {2, 2, 1, 1, 1, 2, 2};
        assert solution.majorityElement(test2) == 2;

        // Test case 3: Single element array
        int[] test3 = {1};
        assert solution.majorityElement(test3) == 1;

        // Test case 4: All elements are same
        int[] test4 = {4, 4, 4, 4};
        assert solution.majorityElement(test4) == 4;

        // Test case 5: Negative numbers
        int[] test5 = {-1, -1, 2, -1};
        assert solution.majorityElement(test5) == -1;

        System.out.println("All test cases passed!");
    }
}
