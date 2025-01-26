
/**
 * Solution class for the Best Time to Buy and Sell Stock problem.
 *
 * Problem Description:
 * Given an array prices[] where prices[i] represents the price of a stock on day i,
 * find the maximum profit that can be obtained by buying and selling the stock once.
 * You must buy before you sell, and you can only perform one transaction.
 *
 * Time Complexity: O(n) where n is the length of the prices array
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Calculates the maximum profit that can be obtained from one stock
     * transaction.
     *
     * @param prices An array of integers where prices[i] is the stock price on
     * day i
     * @return The maximum profit that can be obtained, or 0 if no profit is
     * possible
     * @throws IllegalArgumentException if prices array is null
     */
    public int maxProfit(int[] prices) {
        // Input validation
        if (prices == null) {
            throw new IllegalArgumentException("Prices array cannot be null");
        }

        // Initialize minPrice to a very high value
        int minPrice = Integer.MAX_VALUE;
        // Initialize maxProfit to 0
        int maxProfit = 0;

        // Iterate through the prices array
        for (int price : prices) {
            // Update minPrice if the current price is lower
            if (price < minPrice) {
                minPrice = price;
            }
            // Calculate the potential profit
            int profit = price - minPrice;
            // Update maxProfit if the current profit is greater
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
    }

    /**
     * Test cases to verify the functionality of maxProfit method.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal case with profit
        assert solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}) == 5 : "Test Case 1 Failed";

        // Test Case 2: Decreasing prices, no profit possible
        assert solution.maxProfit(new int[]{7, 6, 4, 3, 1}) == 0 : "Test Case 2 Failed";

        // Test Case 3: Single element
        assert solution.maxProfit(new int[]{1}) == 0 : "Test Case 3 Failed";

        // Test Case 4: Empty array
        assert solution.maxProfit(new int[]{}) == 0 : "Test Case 4 Failed";

        // Test Case 5: Same prices
        assert solution.maxProfit(new int[]{1, 1, 1, 1}) == 0 : "Test Case 5 Failed";

        // Test Case 6: Large profit case
        assert solution.maxProfit(new int[]{1, 2, 4, 8, 16}) == 15 : "Test Case 6 Failed";

        try {
            // Test Case 7: Null input
            solution.maxProfit(null);
            assert false : "Test Case 7 Failed - Should throw IllegalArgumentException";
        } catch (IllegalArgumentException e) {
            // Expected behavior
        }

        System.out.println("All test cases passed!");
    }
}
