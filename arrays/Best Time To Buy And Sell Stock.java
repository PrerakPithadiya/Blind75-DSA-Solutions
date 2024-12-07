
/**
 * Solution for Best Time to Buy and Sell Stock problem
 *
 * Problem: Given an array of stock prices where prices[i] is the price of a given stock on the ith day,
 * find the maximum profit you can achieve by buying and selling once.
 * You must buy before you sell and you can only make one transaction.
 *
 * Time Complexity: O(n) where n is the length of the input array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the maximum profit that can be obtained by buying and selling stock
     * once
     *
     * @param arr Array of daily stock prices
     * @return Maximum profit possible
     */
    public int maxProfit(int[] arr) {
        int buyPrice = Integer.MAX_VALUE, maxProfit = 0;
        for (int sellPrice : arr) {
            if (buyPrice < sellPrice) {
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } else {
                buyPrice = sellPrice;
            }
        }
        return maxProfit;
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Regular case with profit
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        assert solution.maxProfit(prices1) == 5 : "Test Case 1 Failed";

        // Test Case 2: Decreasing prices, no profit
        int[] prices2 = {7, 6, 4, 3, 1};
        assert solution.maxProfit(prices2) == 0 : "Test Case 2 Failed";

        // Test Case 3: Single element
        int[] prices3 = {1};
        assert solution.maxProfit(prices3) == 0 : "Test Case 3 Failed";

        // Test Case 4: Two elements with profit
        int[] prices4 = {1, 2};
        assert solution.maxProfit(prices4) == 1 : "Test Case 4 Failed";

        // Test Case 5: Two elements without profit
        int[] prices5 = {2, 1};
        assert solution.maxProfit(prices5) == 0 : "Test Case 5 Failed";

        System.out.println("All test cases passed!");
    }
}
