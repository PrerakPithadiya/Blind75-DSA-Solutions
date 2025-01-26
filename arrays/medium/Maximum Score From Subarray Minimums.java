
class Solution {

    /**
     * Finds the pair of adjacent elements in an array with the maximum sum.
     *
     * This method iterates through the array and finds two consecutive elements
     * whose sum is maximum among all possible adjacent pairs.
     *
     * Time Complexity: O(n) where n is the length of the array Space
     * Complexity: O(1) as only constant extra space is used
     *
     * @param arr the input array of integers
     * @return the maximum sum of any adjacent pair in the array
     * @throws IllegalArgumentException if the array is null or has less than 2
     * elements
     *
     * Example 1: Input: arr = [2, 3, 4, 1] Output: 7 Explanation: The maximum
     * sum is from pair (3, 4)
     *
     * Example 2: Input: arr = [1, 1] Output: 2 Explanation: The only pair sum
     * is 1 + 1 = 2
     *
     * Example 3: Input: arr = [5, 2, 3, 4] Output: 7 Explanation: The maximum
     * sum is from pair (3, 4)
     */
    public int pairWithMaxSum(int arr[]) {
        // Input validation
        if (arr == null || arr.length < 2) {
            throw new IllegalArgumentException("Array must contain at least 2 elements");
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            int sum = arr[i] + arr[i + 1];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

    // Test cases
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Normal case
        int[] arr1 = {2, 3, 4, 1};
        assert solution.pairWithMaxSum(arr1) == 7 : "Test case 1 failed";

        // Test case 2: Minimum length array
        int[] arr2 = {1, 1};
        assert solution.pairWithMaxSum(arr2) == 2 : "Test case 2 failed";

        // Test case 3: Array with negative numbers
        int[] arr3 = {-2, -1, -3, -4};
        assert solution.pairWithMaxSum(arr3) == -3 : "Test case 3 failed";

        // Test case 4: Array with mixed numbers
        int[] arr4 = {-1, 5, -3, 4};
        assert solution.pairWithMaxSum(arr4) == 4 : "Test case 4 failed";

        try {
            // Test case 5: Empty array
            solution.pairWithMaxSum(new int[]{});
            assert false : "Test case 5 failed: Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            // Test case 6: Null array
            solution.pairWithMaxSum(null);
            assert false : "Test case 6 failed: Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All test cases passed!");
    }
}
