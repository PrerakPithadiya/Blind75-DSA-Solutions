
/**
 * Solution class for calculating sum of two integers without using + or - operators
 * Uses bitwise operations to perform addition
 */
class Solution {

    /**
     * Calculates the sum of two integers using bitwise operations
     *
     * @param a first integer operand
     * @param b second integer operand
     * @return sum of a and b
     *
     * Time Complexity: O(1) - number of iterations depends on number of bits
     * set in b Space Complexity: O(1) - only uses constant extra space
     *
     * Algorithm: 1. Use XOR (^) to get sum without carry 2. Use AND (&) and
     * left shift (<<) to get carry 3. Repeat until no carry is left
     *
     * Example: a = 5 (101), b = 3 (011) Step 1: a = 101 ^ 011 = 110, carry =
     * (101 & 011) << 1 = 010 Step 2: a = 110 ^ 010 = 100, carry = (110 & 010)
     * << 1 = 100 Step 3: a = 100 ^ 100 = 000, carry = (100 & 100) << 1 = 1000
     * Step 4: a = 000 ^ 1000 = 1000, carry = (000 & 1000) << 1 = 0 Result: 1000
     * (8)
     */
    public int getSum(int a, int b) {
        while (b != 0) {
            int carry = (a & b) << 1;  // calculate carry
            a = a ^ b;                 // sum without carry
            b = carry;                 // update b to carry
        }
        return a;
    }

    /**
     * Test cases to verify the implementation
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Positive numbers
        assert solution.getSum(5, 3) == 8 : "Test case 1 failed";

        // Test case 2: Negative numbers
        assert solution.getSum(-5, -3) == -8 : "Test case 2 failed";

        // Test case 3: One positive, one negative
        assert solution.getSum(-5, 3) == -2 : "Test case 3 failed";

        // Test case 4: Zero and positive
        assert solution.getSum(0, 5) == 5 : "Test case 4 failed";

        // Test case 5: Zero and negative
        assert solution.getSum(0, -5) == -5 : "Test case 5 failed";

        // Test case 6: Large numbers
        assert solution.getSum(1000, 2000) == 3000 : "Test case 6 failed";

        System.out.println("All test cases passed!");
    }
}
