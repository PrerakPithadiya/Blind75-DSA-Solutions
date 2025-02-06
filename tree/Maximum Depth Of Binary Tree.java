
/**
 * Definition for a binary tree node.
 * This class represents a node in a binary tree data structure.
 * Each node contains an integer value and references to its left and right child nodes.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

}

/**
 * Solution class for finding the maximum depth of a binary tree. The maximum
 * depth is the number of nodes along the longest path from the root node down
 * to the farthest leaf node.
 */
class Solution {

    /**
     * Calculates the maximum depth of a binary tree.
     *
     * @param root The root node of the binary tree
     * @return The maximum depth of the tree
     *
     * Algorithm: 1. If the root is null, return 0 (base case) 2. Recursively
     * calculate the depth of left and right subtrees 3. Return 1 (current node)
     * plus the maximum of left and right depths
     *
     * Time Complexity: O(n) where n is the number of nodes in the tree Space
     * Complexity: O(h) where h is the height of the tree (due to recursion
     * stack)
     */
    public int maxDepth(TreeNode root) {
        // Base case: if the root is null, return depth as 0
        if (root == null) {
            return 0;
        }

        // Recursive case: calculate the depth of the left and right subtrees
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);

        // The depth of the current node is 1 + the maximum of the depths of its subtrees
        return 1 + Math.max(leftDepth, rightDepth);
    }

    /**
     * Test cases to verify the functionality of the maxDepth method
     */
    public void runTests() {
        // Test Case 1: Empty tree
        assert maxDepth(null) == 0 : "Empty tree should have depth 0";

        // Test Case 2: Single node tree
        TreeNode root1 = new TreeNode(1);
        assert maxDepth(root1) == 1 : "Single node tree should have depth 1";

        // Test Case 3: Complete binary tree
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        assert maxDepth(root2) == 2 : "Complete binary tree with 3 nodes should have depth 2";

        // Test Case 4: Unbalanced tree
        TreeNode root3 = new TreeNode(1);
        root3.left = new TreeNode(2);
        root3.left.left = new TreeNode(3);
        root3.left.left.left = new TreeNode(4);
        assert maxDepth(root3) == 4 : "Unbalanced tree should have depth 4";

        // Test Case 5: Complex tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.right = new TreeNode(6);
        root4.left.left.left = new TreeNode(7);
        assert maxDepth(root4) == 4 : "Complex tree should have depth 4";

        System.out.println("All test cases passed successfully!");
    }
}
