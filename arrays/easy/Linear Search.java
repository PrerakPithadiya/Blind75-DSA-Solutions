
/**
 * Solution class containing methods for searching in sorted arrays
 */
class Solution {

    /**
     * Searches for a given element in a sorted array using linear search
     *
     * @param arr The sorted array to search in
     * @param k The element to search for
     * @return true if element is found, false otherwise
     * @throws IllegalArgumentException if array is null
     */
    static boolean searchInSorted(int arr[], int k) {
        // Input validation
        if (arr == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        // Iterate through the array
        for (int i = 0; i < arr.length; i++) {
            // If the element is found, return true
            if (arr[i] == k) {
                return true;
            }
        }
        // If the element is not found, return false
        return false;
    }

    /**
     * Main method to test the searchInSorted functionality
     */
    public static void main(String[] args) {
        // Test case 1: Basic search
        int[] arr1 = {1, 2, 3, 4, 5};
        System.out.println("Test 1: " + searchInSorted(arr1, 3));  // Expected: true

        // Test case 2: Element not present
        System.out.println("Test 2: " + searchInSorted(arr1, 6));  // Expected: false

        // Test case 3: Empty array
        int[] arr2 = {};
        System.out.println("Test 3: " + searchInSorted(arr2, 1));  // Expected: false

        // Test case 4: Single element array
        int[] arr3 = {1};
        System.out.println("Test 4: " + searchInSorted(arr3, 1));  // Expected: true

        // Test case 5: Array with duplicate elements
        int[] arr4 = {1, 2, 2, 3, 3, 3};
        System.out.println("Test 5: " + searchInSorted(arr4, 2));  // Expected: true

        try {
            // Test case 6: Null array
            searchInSorted(null, 1);
        } catch (IllegalArgumentException e) {
            System.out.println("Test 6: Exception caught successfully");
        }
    }
}
