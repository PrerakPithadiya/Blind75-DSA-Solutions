
/**
 * Solution for Binary Tree Maximum Path Sum problem
 *
 * Problem Description:
 * Given a binary tree, find the maximum path sum. A path is defined as any node sequence from some starting node to any node
 * in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
 *
 * Time Complexity: O(n) where n is the number of nodes in the tree
 * Space Complexity: O(h) where h is the height of the tree (due to recursion stack)
 */
class Solution {

    // Global variable to store the maximum path sum
    private int maxSum = Integer.MIN_VALUE;

    /**
     * Main method to find the maximum path sum in a binary tree
     *
     * @param root The root node of the binary tree
     * @return The maximum path sum found in the tree
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) {
            throw new IllegalArgumentException("Input tree cannot be null");
        }
        calculateMaxSum(root);
        return maxSum;
    }

    /**
     * Helper method to calculate the maximum path sum recursively
     *
     * @param node Current node being processed
     * @return Maximum path sum from the current node to any leaf, considering
     * only one branch (left or right)
     */
    private int calculateMaxSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // Recursively calculate the maximum path sum for the left and right subtrees
        // If the path sum is negative, we don't include it (hence Math.max with 0)
        int leftMax = Math.max(0, calculateMaxSum(node.left));
        int rightMax = Math.max(0, calculateMaxSum(node.right));

        // Calculate the maximum path sum including the current node as the root
        // This path can include both left and right branches
        int currentMaxPath = node.val + leftMax + rightMax;

        // Update the global maximum path sum if the current path is larger
        maxSum = Math.max(maxSum, currentMaxPath);

        // Return the maximum path sum that can be extended to the parent node
        // We can only choose one branch (left or right) when extending to parent
        return node.val + Math.max(leftMax, rightMax);
    }

    /**
     * Test cases for the maxPathSum method
     */
    public void runTests() {
        // Test Case 1: Single node
        TreeNode test1 = new TreeNode(1);
        assert maxPathSum(test1) == 1 : "Test Case 1 Failed";

        // Test Case 2: Simple tree with positive values
        TreeNode test2 = new TreeNode(1);
        test2.left = new TreeNode(2);
        test2.right = new TreeNode(3);
        assert maxPathSum(test2) == 6 : "Test Case 2 Failed";

        // Test Case 3: Tree with negative values
        TreeNode test3 = new TreeNode(-10);
        test3.left = new TreeNode(9);
        test3.right = new TreeNode(20);
        test3.right.left = new TreeNode(15);
        test3.right.right = new TreeNode(7);
        assert maxPathSum(test3) == 42 : "Test Case 3 Failed";

        // Test Case 4: Tree with all negative values
        TreeNode test4 = new TreeNode(-3);
        test4.left = new TreeNode(-2);
        test4.right = new TreeNode(-1);
        assert maxPathSum(test4) == -1 : "Test Case 4 Failed";

        System.out.println("All test cases passed!");
    }
}
