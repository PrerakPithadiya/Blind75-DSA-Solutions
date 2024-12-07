
import java.util.HashSet;

/**
 * Solution class containing method to check for duplicates in an array
 */
class Solution {

    /**
     * Determines if an array contains any duplicate elements
     *
     * @param nums Array of integers to check for duplicates
     * @return true if any element appears at least twice, false otherwise
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
     * Main method with test cases
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
    }

}
