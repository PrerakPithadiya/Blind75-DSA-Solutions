package binary;

/**
 * Solution for counting the number of 1 bits (Hamming Weight) in an integer
 *
 * Problem: Write a function that takes an unsigned integer and returns the
 * number of '1' bits it has (also known as the Hamming weight).
 *
 * Approach: - Uses Brian Kernighan's algorithm to count set bits - In each
 * iteration, we remove the rightmost set bit using n & (n-1) - Time Complexity:
 * O(k) where k is the number of set bits - Space Complexity: O(1)
 */
class Solution {

    /**
     * Calculates the Hamming weight (number of 1 bits) in the given integer
     *
     * @param n The input integer for which to count set bits
     * @return The number of 1 bits in the input integer
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            // Remove the least significant set bit
            n &= (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Test cases to verify the hammingWeight function
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Number with multiple 1 bits
        assert solution.hammingWeight(11) == 3 : "Test case 1 failed"; // 11 = 1011 in binary

        // Test case 2: Power of 2 (single 1 bit)
        assert solution.hammingWeight(16) == 1 : "Test case 2 failed"; // 16 = 10000 in binary

        // Test case 3: Zero (no 1 bits)
        assert solution.hammingWeight(0) == 0 : "Test case 3 failed";

        // Test case 4: All 1s in 32-bit integer
        assert solution.hammingWeight(-1) == 32 : "Test case 4 failed";

        // Test case 5: Alternating bits
        assert solution.hammingWeight(0x55555555) == 16 : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
