
import java.util.HashSet;

/**
 * Solution class containing method to check for duplicates in an array. This
 * class provides functionality to determine if an array contains any duplicate
 * elements using a HashSet for efficient lookup operations.
 *
 * Time Complexity: O(n) where n is the length of the input array Space
 * Complexity: O(n) to store elements in the HashSet
 */
class Solution {

    /**
     * Determines if an array contains any duplicate elements by using a HashSet
     * to track previously seen elements.
     *
     * @param nums Array of integers to check for duplicates
     * @return true if any element appears at least twice, false otherwise
     *
     * Algorithm: 1. Create an empty HashSet to store unique elements 2. Iterate
     * through each element in the input array 3. For each element, check if it
     * already exists in the HashSet - If yes, return true (duplicate found) -
     * If no, add the element to the HashSet 4. If loop completes without
     * finding duplicates, return false
     *
     * Edge cases handled: - Empty array (returns false) - Array with single
     * element (returns false) - Array with negative numbers - Array with
     * multiple duplicates
     */
    public boolean containsDuplicate(int[] nums) {
        // Create a HashSet to store unique elements
        HashSet<Integer> seen = new HashSet<>();

        // Iterate through the array
        for (int num : nums) {
            // Check if the number is already in the set
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            // Add the number to the set
            seen.add(num);
        }

        // No duplicates found
        return false;
    }

    /**
     * Main method with comprehensive test cases to verify the functionality of
     * the containsDuplicate method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Array with duplicates
        int[] test1 = {1, 2, 3, 1};
        System.out.println("Test 1: " + solution.containsDuplicate(test1)); // Expected: true

        // Test Case 2: Array without duplicates
        int[] test2 = {1, 2, 3, 4};
        System.out.println("Test 2: " + solution.containsDuplicate(test2)); // Expected: false

        // Test Case 3: Array with multiple duplicates
        int[] test3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println("Test 3: " + solution.containsDuplicate(test3)); // Expected: true

        // Test Case 4: Empty array
        int[] test4 = {};
        System.out.println("Test 4: " + solution.containsDuplicate(test4)); // Expected: false

        // Test Case 5: Array with single element
        int[] test5 = {1};
        System.out.println("Test 5: " + solution.containsDuplicate(test5)); // Expected: false

        // Test Case 6: Array with negative numbers
        int[] test6 = {-1, -1, -2, -3, -4};
        System.out.println("Test 6: " + solution.containsDuplicate(test6)); // Expected: true

        // Test Case 7: Array with mixed positive and negative numbers
        int[] test7 = {-1, 0, 1, -2, 2};
        System.out.println("Test 7: " + solution.containsDuplicate(test7)); // Expected: false

        // Test Case 8: Array with large numbers
        int[] test8 = {Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE};
        System.out.println("Test 8: " + solution.containsDuplicate(test8)); // Expected: true

        // Test Case 9: Array with zeros
        int[] test9 = {0, 0, 0};
        System.out.println("Test 9: " + solution.containsDuplicate(test9)); // Expected: true

        // Test Case 10: Array with consecutive numbers
        int[] test10 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println("Test 10: " + solution.containsDuplicate(test10)); // Expected: false
    }
}
