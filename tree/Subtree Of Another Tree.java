
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Solution for checking if a binary tree is a subtree of another binary tree.
 * LeetCode Problem 572: Subtree of Another Tree
 *
 * Time Complexity: O(m * n) where m and n are the number of nodes in root and subRoot trees respectively
 * Space Complexity: O(h) where h is the height of the tree due to recursion stack
 */
class Solution {

    /**
     * Checks if a binary tree is a subtree of another binary tree.
     *
     * @param root The root node of the main tree
     * @param subRoot The root node of the tree to be checked as subtree
     * @return true if subRoot is a subtree of root, false otherwise
     */
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // Base cases
        if (subRoot == null) {
            return true;  // Empty tree is a subtree of any tree

        }
        if (root == null) {
            return false;    // Non-empty tree cannot be a subtree of empty tree
        }
        // Check if the trees rooted at current root and subRoot are identical
        if (isSameTree(root, subRoot)) {
            return true;
        }

        // Otherwise, recursively check the left and right subtrees
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    /**
     * Helper function to check if two trees are identical in structure and
     * values.
     *
     * @param p Root node of first tree
     * @param q Root node of second tree
     * @return true if trees are identical, false otherwise
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are null, they are identical
        if (p == null && q == null) {
            return true;
        }
        // If one is null but the other is not, they are not identical
        if (p == null || q == null) {
            return false;
        }
        // If the values of the current nodes are different, they are not identical
        if (p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Test cases for the solution.
     */
    public void testCases() {
        // Test Case 1: Basic case
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(2);

        TreeNode subRoot1 = new TreeNode(4);
        subRoot1.left = new TreeNode(1);
        subRoot1.right = new TreeNode(2);
        assert isSubtree(root1, subRoot1) == true;

        // Test Case 2: Empty subtree
        assert isSubtree(root1, null) == true;

        // Test Case 3: Empty main tree
        assert isSubtree(null, subRoot1) == false;

        // Test Case 4: Same trees
        assert isSubtree(root1, root1) == true;

        // Test Case 5: Different structure
        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);
        root2.left.left = new TreeNode(1);

        assert isSubtree(root2, subRoot1) == false;
    }
}
