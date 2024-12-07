
/**
 * Solution class for reversing bits of a 32-bit unsigned integer.
 *
 * Problem: Reverse bits of a given 32 bits unsigned integer.
 *
 * Example 1:
 * Input: n = 43261596 (00000010100101000001111010011100)
 * Output: 964176192 (00111001011110000010100101000000)
 *
 * Example 2:
 * Input: n = 4294967293 (11111111111111111111111111111101)
 * Output: 3221225471 (10111111111111111111111111111111)
 *
 * Time Complexity: O(1) - constant time as we always process 32 bits
 * Space Complexity: O(1) - constant space used
 */
class Solution {

    /**
     * Reverses the bits of a 32-bit unsigned integer.
     *
     * Algorithm: 1. Initialize result to 0 2. For each of the 32 bits: -
     * Extract the least significant bit using AND operation - Left shift result
     * by 1 and append the extracted bit - Right shift n by 1 to process next
     * bit 3. Return the final result
     *
     * @param n the 32-bit unsigned integer to reverse
     * @return the reversed bits as a 32-bit unsigned integer
     */
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Extract the least significant bit of n
            int bit = n & 1;
            // Append the bit to result at the reversed position
            result = (result << 1) | bit;
            // Shift n to the right to process the next bit
            n >>= 1;
        }
        return result;
    }

    /**
     * Test cases to verify the implementation
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Regular number
        assert solution.reverseBits(43261596) == 964176192 : "Test case 1 failed";

        // Test Case 2: Number with many 1s
        assert solution.reverseBits(4294967293L) == 3221225471L : "Test case 2 failed";

        // Test Case 3: Zero
        assert solution.reverseBits(0) == 0 : "Test case 3 failed";

        // Test Case 4: All ones
        assert solution.reverseBits(-1) == -1 : "Test case 4 failed";

        // Test Case 5: Single 1
        assert solution.reverseBits(1) == Integer.MIN_VALUE : "Test case 5 failed";

        System.out.println("All test cases passed!");
    }
}
