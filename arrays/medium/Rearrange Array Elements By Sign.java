
/**
 * Solution class for rearranging array elements by sign
 * Problem: Given an array of positive and negative integers, rearrange them such that
 * positive and negative numbers alternate, with positive numbers at even indices.
 */
class Solution {

    /**
     * Rearranges the input array such that positive and negative numbers
     * alternate. Time Complexity: O(n) where n is the length of input array
     * Space Complexity: O(n) for the result array
     *
     * @param nums Input array containing positive and negative integers
     * @return Array with alternating positive and negative numbers
     * @throws IllegalArgumentException if the input array is null or has odd
     * length or doesn't have equal number of positive and negative integers
     */
    public int[] rearrangeArray(int[] nums) {
        // Input validation
        if (nums == null) {
            throw new IllegalArgumentException("Input array cannot be null");
        }
        if (nums.length % 2 != 0) {
            throw new IllegalArgumentException("Array length must be even");
        }

        int n = nums.length;
        int[] result = new int[n];
        int posIndex = 0, negIndex = 1;
        int posCount = 0, negCount = 0;

        // Count positive and negative numbers
        for (int num : nums) {
            if (num > 0) {
                posCount++;
            } else {
                negCount++;
            }
        }

        // Validate equal count
        if (posCount != negCount) {
            throw new IllegalArgumentException("Array must have equal number of positive and negative integers");
        }

        // Rearrange array
        for (int num : nums) {
            if (num > 0) {
                result[posIndex] = num;
                posIndex += 2;
            } else {
                result[negIndex] = num;
                negIndex += 2;
            }
        }
        return result;
    }

    /**
     * Test cases for the rearrangeArray method
     */
    public void testRearrangeArray() {
        // Test case 1: Normal case
        assert Arrays.equals(rearrangeArray(new int[]{3, -2, 1, -5, 2, -4}),
                new int[]{3, 2, 1, -5, 2, -4});

        // Test case 2: Minimum valid array
        assert Arrays.equals(rearrangeArray(new int[]{1, -1}),
                new int[]{1, -1});

        // Test case 3: Array with larger numbers
        assert Arrays.equals(rearrangeArray(new int[]{1000, -1000, 2000, -2000}),
                new int[]{1000, -1000, 2000, -2000});

        try {
            // Test case 4: Null array
            rearrangeArray(null);
            assert false : "Should throw IllegalArgumentException for null input";
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            // Test case 5: Odd length array
            rearrangeArray(new int[]{1, -1, 2});
            assert false : "Should throw IllegalArgumentException for odd length";
        } catch (IllegalArgumentException e) {
            assert true;
        }

        try {
            // Test case 6: Unequal positive/negative numbers
            rearrangeArray(new int[]{1, 2, -1, -1});
            assert false : "Should throw IllegalArgumentException for unequal positive/negative count";
        } catch (IllegalArgumentException e) {
            assert true;
        }
    }
}
