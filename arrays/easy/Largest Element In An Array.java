
/**
 * Solution class containing method to find largest element in an array
 */
class Solution {

    /**
     * Finds the largest element in an integer array
     *
     * @param arr The input integer array
     * @return The largest element in the array
     * @throws IllegalArgumentException if array is null or empty
     */
    public static int largest(int[] arr) {
        // Input validation
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }

        int max = arr[0]; // Initialize max with the first element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i]; // Update max if current element is greater
            }
        }
        return max; // Return the largest element
    }

    /**
     * Main method with test cases
     */
    public static void main(String[] args) {
        // Test Case 1: Normal array with positive numbers
        int[] arr1 = {1, 8, 7, 56, 90};
        System.out.println("Test Case 1: Expected 90, Got " + largest(arr1));

        // Test Case 2: Array with negative numbers
        int[] arr2 = {-1, -8, -7, -56, -90};
        System.out.println("Test Case 2: Expected -1, Got " + largest(arr2));

        // Test Case 3: Array with mixed numbers
        int[] arr3 = {1, -8, 7, -56, 90};
        System.out.println("Test Case 3: Expected 90, Got " + largest(arr3));

        // Test Case 4: Array with single element
        int[] arr4 = {5};
        System.out.println("Test Case 4: Expected 5, Got " + largest(arr4));

        // Test Case 5: Array with duplicate elements
        int[] arr5 = {1, 8, 8, 8, 8};
        System.out.println("Test Case 5: Expected 8, Got " + largest(arr5));

        try {
            // Test Case 6: Empty array
            int[] arr6 = {};
            largest(arr6);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 6: Successfully caught empty array exception");
        }

        try {
            // Test Case 7: Null array
            largest(null);
        } catch (IllegalArgumentException e) {
            System.out.println("Test Case 7: Successfully caught null array exception");
        }
    }
}
