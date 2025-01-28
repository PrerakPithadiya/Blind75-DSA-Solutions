
/**
 * Solution for the "Climbing Stairs" problem.
 *
 * Problem Description:
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps.
 * Calculate in how many distinct ways you can climb to the top.
 *
 * Approach:
 * - Uses Dynamic Programming with space optimization
 * - At each step i, ways to reach = ways to reach from (i-1) + ways to reach from (i-2)
 * - Similar to Fibonacci sequence
 *
 * Time Complexity: O(n) - where n is the number of stairs
 * Space Complexity: O(1) - only using three variables
 */
class Solution {

    /**
     * Calculates the number of distinct ways to climb n stairs.
     *
     * @param n The number of stairs to climb (n >= 1)
     * @return The number of distinct ways to climb n stairs
     * @throws IllegalArgumentException if n < 1
     */
    public int climbStairs(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Number of stairs must be positive");
        }

        if (n == 1) {
            return 1;
        }

        int first = 1;  // represents ways to climb 0 stairs
        int second = 1; // represents ways to climb 1 stair

        for (int i = 2; i <= n; i++) {
            int current = first + second; // ways for current step
            first = second;
            second = current;
        }

        return second;
    }

    /**
     * Test cases to verify the solution.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: n = 2
        assert solution.climbStairs(2) == 2 : "Test case 1 failed";
        // Explanation: There are two ways: 1+1 and 2

        // Test case 2: n = 3
        assert solution.climbStairs(3) == 3 : "Test case 2 failed";
        // Explanation: There are three ways: 1+1+1, 1+2, 2+1

        // Test case 3: n = 4
        assert solution.climbStairs(4) == 5 : "Test case 3 failed";
        // Explanation: There are five ways: 1+1+1+1, 1+1+2, 1+2+1, 2+1+1, 2+2

        // Test case 4: n = 1
        assert solution.climbStairs(1) == 1 : "Test case 4 failed";
        // Explanation: There is one way: 1

        // Test case 5: Error case
        try {
            solution.climbStairs(0);
            assert false : "Test case 5 failed: Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All test cases passed!");
    }
}
