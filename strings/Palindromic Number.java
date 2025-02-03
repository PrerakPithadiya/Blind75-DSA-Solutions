
/**
 * Solution class for checking if a number is palindromic.
 * A palindromic number reads the same forwards and backwards.
 */
class Solution {

    /**
     * Determines if the given integer is a palindrome.
     *
     * @param n The integer to check for palindrome property
     * @return true if the number is palindromic, false otherwise
     *
     * Examples: - isPalindrome(121) returns true (121 reads as 121 from both
     * directions) - isPalindrome(-121) returns false (negative numbers are not
     * palindromes) - isPalindrome(10) returns false (10 reads as 01 from right
     * to left)
     *
     * Note: The function handles integer overflow cases automatically due to
     * the way reversal is performed digit by digit.
     */
    public boolean isPalindrome(int n) {
        // Negative numbers are not palindromes
        if (n < 0) {
            return false;
        }

        // Single digit numbers are always palindromes
        if (n >= 0 && n < 10) {
            return true;
        }

        // Store original number for comparison
        int org = n;
        int rev = 0;

        // Reverse the number
        while (n != 0) {
            // Check for potential overflow before adding
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && n % 10 > 7)) {
                return false;
            }
            rev = rev * 10 + (n % 10);
            n /= 10;
        }

        return rev == org;
    }

    /**
     * Test cases to verify the isPalindrome function.
     */
    public void runTests() {
        // Test case 1: Regular palindrome
        assert isPalindrome(121) == true : "Test case 1 failed";

        // Test case 2: Negative number
        assert isPalindrome(-121) == false : "Test case 2 failed";

        // Test case 3: Non-palindrome
        assert isPalindrome(123) == false : "Test case 3 failed";

        // Test case 4: Single digit
        assert isPalindrome(7) == true : "Test case 4 failed";

        // Test case 5: Zero
        assert isPalindrome(0) == true : "Test case 5 failed";

        // Test case 6: Even length palindrome
        assert isPalindrome(1221) == true : "Test case 6 failed";

        // Test case 7: Number ending with zero
        assert isPalindrome(10) == false : "Test case 7 failed";

        System.out.println("All test cases passed!");
    }
}
