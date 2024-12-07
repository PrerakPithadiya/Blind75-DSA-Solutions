
class Solution {

    public int[] countBits(int n) {
        int[] ans = new int[n + 1];

        // Fill the ans array using the previously described relation
        for (int i = 0; i <= n; i++) {
            // The number of 1's in i is equal to the number of 1's in i/2 plus the least significant bit of i
            ans[i] = ans[i >> 1] + (i & 1);
        }

        return ans;
    }
}
