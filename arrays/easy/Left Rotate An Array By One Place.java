
/**
 * Solution class for array rotation operations
 * This class provides methods to rotate an array to the right by k positions
 */
class Solution {

    /**
     * Rotates an array to the right by k positions Time Complexity: O(n) where
     * n is the length of the array Space Complexity: O(1) as it uses constant
     * extra space
     *
     * @param nums The input array to be rotated
     * @param k The number of positions to rotate right
     */
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        // Ensure k is within bounds of the array's length
        k = k % n;

        // Step 1: Reverse the entire array
        reverse(nums, 0, n - 1);

        // Step 2: Reverse the first k elements
        reverse(nums, 0, k - 1);

        // Step 3: Reverse the remaining elements
        reverse(nums, k, n - 1);
    }

    /**
     * Helper method to reverse a portion of the array Time Complexity: O(n)
     * where n is the length of the portion being reversed Space Complexity:
     * O(1)
     *
     * @param nums The array containing the portion to be reversed
     * @param start The starting index of the portion to reverse
     * @param end The ending index of the portion to reverse
     */
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * Main method to test the rotation functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic rotation
        int[] arr1 = {1, 2, 3, 4, 5, 6, 7};
        System.out.println("Test Case 1 - Before rotation: " + java.util.Arrays.toString(arr1));
        solution.rotate(arr1, 3);
        System.out.println("After rotating by 3: " + java.util.Arrays.toString(arr1));
        // Expected: [5, 6, 7, 1, 2, 3, 4]

        // Test Case 2: Rotation with k > array length
        int[] arr2 = {-1, -100, 3, 99};
        System.out.println("\nTest Case 2 - Before rotation: " + java.util.Arrays.toString(arr2));
        solution.rotate(arr2, 6);
        System.out.println("After rotating by 6: " + java.util.Arrays.toString(arr2));
        // Expected: [3, 99, -1, -100]

        // Test Case 3: Empty array
        int[] arr3 = {};
        System.out.println("\nTest Case 3 - Empty array: " + java.util.Arrays.toString(arr3));
        solution.rotate(arr3, 1);
        System.out.println("After rotating by 1: " + java.util.Arrays.toString(arr3));
        // Expected: []

        // Test Case 4: Single element array
        int[] arr4 = {1};
        System.out.println("\nTest Case 4 - Single element: " + java.util.Arrays.toString(arr4));
        solution.rotate(arr4, 1);
        System.out.println("After rotating by 1: " + java.util.Arrays.toString(arr4));
        // Expected: [1]

        // Test Case 5: Zero rotation
        int[] arr5 = {1, 2, 3};
        System.out.println("\nTest Case 5 - Before rotation: " + java.util.Arrays.toString(arr5));
        solution.rotate(arr5, 0);
        System.out.println("After rotating by 0: " + java.util.Arrays.toString(arr5));
        // Expected: [1, 2, 3]
    }
}
