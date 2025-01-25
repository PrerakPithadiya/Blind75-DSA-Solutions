
import java.util.ArrayList;

/**
 * Solution class containing method to find union of two sorted arrays with
 * duplicates. Time Complexity: O(m + n) where m and n are lengths of input
 * arrays Space Complexity: O(m + n) for storing the union result
 */
class Solution {

    /**
     * Finds the union of two sorted arrays while handling duplicates. The
     * function maintains the sorted order in the result and eliminates
     * duplicates.
     *
     * @param a First sorted array
     * @param b Second sorted array
     * @return ArrayList containing union of elements from both arrays without
     * duplicates
     * @throws NullPointerException if either array is null
     */
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // Input validation
        if (a == null || b == null) {
            throw new NullPointerException("Input arrays cannot be null");
        }

        ArrayList<Integer> union = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.length && j < b.length) {
            // Skip duplicates in array a
            while (i > 0 && i < a.length && a[i] == a[i - 1]) {
                i++;
            }
            // Skip duplicates in array b
            while (j > 0 && j < b.length && b[j] == b[j - 1]) {
                j++;
            }

            // Check bounds after skipping duplicates
            if (i < a.length && j < b.length) {
                if (a[i] < b[j]) {
                    union.add(a[i++]);
                } else if (a[i] > b[j]) {
                    union.add(b[j++]);
                } else {
                    union.add(a[i]);
                    i++;
                    j++;
                }
            }
        }

        // Add remaining elements of array a
        while (i < a.length) {
            if (i == 0 || a[i] != a[i - 1]) {
                union.add(a[i]);
            }
            i++;
        }

        // Add remaining elements of array b
        while (j < b.length) {
            if (j == 0 || b[j] != b[j - 1]) {
                union.add(b[j]);
            }
            j++;
        }

        return union;
    }

    /**
     * Test cases to verify the functionality of findUnion method
     */
    public static void main(String[] args) {
        // Test Case 1: Regular arrays with some common elements
        int[] arr1 = {1, 2, 2, 3, 4};
        int[] arr2 = {2, 3, 3, 4, 5};
        ArrayList<Integer> result1 = findUnion(arr1, arr2);
        System.out.println("Test Case 1: " + result1); // Expected: [1, 2, 3, 4, 5]

        // Test Case 2: Arrays with no common elements
        int[] arr3 = {1, 3, 5};
        int[] arr4 = {2, 4, 6};
        ArrayList<Integer> result2 = findUnion(arr3, arr4);
        System.out.println("Test Case 2: " + result2); // Expected: [1, 2, 3, 4, 5, 6]

        // Test Case 3: One empty array
        int[] arr5 = {};
        int[] arr6 = {1, 2, 3};
        ArrayList<Integer> result3 = findUnion(arr5, arr6);
        System.out.println("Test Case 3: " + result3); // Expected: [1, 2, 3]

        // Test Case 4: Arrays with all duplicate elements
        int[] arr7 = {1, 1, 1};
        int[] arr8 = {1, 1, 1};
        ArrayList<Integer> result4 = findUnion(arr7, arr8);
        System.out.println("Test Case 4: " + result4); // Expected: [1]

        // Test Case 5: Arrays with negative numbers
        int[] arr9 = {-3, -2, -1};
        int[] arr10 = {-2, -1, 0};
        ArrayList<Integer> result5 = findUnion(arr9, arr10);
        System.out.println("Test Case 5: " + result5); // Expected: [-3, -2, -1, 0]
    }
}
