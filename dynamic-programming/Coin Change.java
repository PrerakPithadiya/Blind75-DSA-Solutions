
import java.util.Arrays;

/**
 * Solution class for the Coin Change problem Problem: Given an array of coin
 * denominations and a target amount, find the minimum number of coins needed to
 * make up that amount.
 */
class Solution {

    /**
     * Finds the minimum number of coins needed to make up the target amount
     * using dynamic programming approach.
     *
     * @param coins Array of available coin denominations
     * @param amount Target amount to make up
     * @return Minimum number of coins needed, or -1 if amount cannot be made
     *
     * Time Complexity: O(amount * number of coins) Space Complexity: O(amount)
     */
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);  // Initialize dp array with max value
        dp[0] = 0;  // Base case: 0 coins needed to make amount 0

        // Iterate over each amount from 1 to amount
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        // If dp[amount] is still max, it means amount cannot be formed
        return dp[amount] == max ? -1 : dp[amount];
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] coins1 = {1, 2, 5};
        int amount1 = 11;
        assert solution.coinChange(coins1, amount1) == 3;  // 5 + 5 + 1 = 11

        // Test Case 2: No solution possible
        int[] coins2 = {2};
        int amount2 = 3;
        assert solution.coinChange(coins2, amount2) == -1;

        // Test Case 3: Zero amount
        int[] coins3 = {1, 2, 5};
        int amount3 = 0;
        assert solution.coinChange(coins3, amount3) == 0;

        // Test Case 4: Single coin exact match
        int[] coins4 = {1};
        int amount4 = 1;
        assert solution.coinChange(coins4, amount4) == 1;

        // Test Case 5: Multiple valid solutions (should return minimum)
        int[] coins5 = {1, 2, 5};
        int amount5 = 4;
        assert solution.coinChange(coins5, amount5) == 2;  // 2 + 2 = 4

        System.out.println("All test cases passed!");
    }
}
