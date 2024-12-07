
/**
 * Solution class for finding the missing number in a sequence from 0 to n.
 * Time Complexity: O(n) where n is the length of input array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the missing number in an array containing n distinct numbers in the
     * range [0, n].
     *
     * The method uses the mathematical formula for sum of first n natural
     * numbers: n * (n + 1) / 2 By subtracting the sum of array elements from
     * this total sum, we get the missing number.
     *
     * @param arr Input array containing n distinct numbers from 0 to n, with
     * one number missing
     * @return The missing number in the sequence
     *
     * Example 1: Input: arr = [3,0,1] Output: 2 Explanation: n = 3 since array
     * length is 3. Numbers 0,1,3 are in array, so 2 is missing.
     *
     * Example 2: Input: arr = [0,1] Output: 2 Explanation: n = 2 since array
     * length is 2. Numbers 0,1 are in array, so 2 is missing.
     *
     * Example 3: Input: arr = [9,6,4,2,3,5,7,0,1] Output: 8 Explanation: n = 9
     * since array length is 9. Numbers 0-7,9 are in array, so 8 is missing.
     */
    public int missingNumber(int[] arr) {
        int n = arr.length, totalSum = (n * (n + 1)) / 2, currSum = 0;
        for (int element : arr) {
            currSum += element;
        }
        return totalSum - currSum;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1
        int[] test1 = {3, 0, 1};
        assert solution.missingNumber(test1) == 2 : "Test case 1 failed";

        // Test case 2
        int[] test2 = {0, 1};
        assert solution.missingNumber(test2) == 2 : "Test case 2 failed";

        // Test case 3
        int[] test3 = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        assert solution.missingNumber(test3) == 8 : "Test case 3 failed";

        // Test case 4: Edge case with single element
        int[] test4 = {0};
        assert solution.missingNumber(test4) == 1 : "Test case 4 failed";

        // Test case 5: Edge case with missing 0
        int[] test5 = {1};
        assert solution.missingNumber(test5) == 0 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
