
import java.util.*;

/**
 * Solution class for finding all unique combinations of numbers that sum up to
 * a target. This implementation uses backtracking to explore all possible
 * combinations.
 */
class Solution {

    /**
     * Finds all unique combinations of numbers from candidates that sum to
     * target. Each number in candidates may be used multiple times in the
     * combination.
     *
     * @param candidates Array of distinct positive integers to choose from
     * @param target The target sum to achieve
     * @return List of all unique combinations that sum to target
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    /**
     * Helper method that implements the backtracking algorithm.
     *
     * @param result The final list containing all valid combinations
     * @param tempList The current combination being built
     * @param candidates Array of available numbers to use
     * @param remain The remaining sum needed to reach target
     * @param start The starting index to consider from candidates array
     */
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // Base case: if remain is 0, the current combination is valid
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        // Explore each candidate
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remain) {  // Only explore if the current candidate is <= remaining target
                tempList.add(candidates[i]); // Choose the current candidate
                // Recurse, but allow the same candidate (i) to be reused
                backtrack(result, tempList, candidates, remain - candidates[i], i);
                tempList.remove(tempList.size() - 1); // Backtrack, remove the last added number
            }
        }
    }

    /**
     * Test cases to verify the solution
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Basic case
        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        List<List<Integer>> result1 = solution.combinationSum(candidates1, target1);
        System.out.println("Test Case 1:");
        System.out.println("Input: candidates = [2,3,6,7], target = 7");
        System.out.println("Expected: [[2,2,3],[7]]");
        System.out.println("Output: " + result1);

        // Test Case 2: Multiple combinations
        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        List<List<Integer>> result2 = solution.combinationSum(candidates2, target2);
        System.out.println("\nTest Case 2:");
        System.out.println("Input: candidates = [2,3,5], target = 8");
        System.out.println("Expected: [[2,2,2,2],[2,3,3],[3,5]]");
        System.out.println("Output: " + result2);

        // Test Case 3: Single element
        int[] candidates3 = {2};
        int target3 = 1;
        List<List<Integer>> result3 = solution.combinationSum(candidates3, target3);
        System.out.println("\nTest Case 3:");
        System.out.println("Input: candidates = [2], target = 1");
        System.out.println("Expected: []");
        System.out.println("Output: " + result3);
    }
}
