
/**
 * Definition for a binary tree node.
 * This class represents a node in a binary tree data structure.
 */
class TreeNode {

    int val;            // The value stored in the node
    TreeNode left;      // Reference to the left child node
    TreeNode right;     // Reference to the right child node

    /**
     * Constructor to create a new TreeNode
     *
     * @param val The value to be stored in the node
     */
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

/**
 * Solution class for validating Binary Search Trees (BST) A valid BST is
 * defined as follows: - The left subtree of a node contains only nodes with
 * keys less than the node's key. - The right subtree of a node contains only
 * nodes with keys greater than the node's key. - Both the left and right
 * subtrees must also be binary search trees.
 */
class Solution {

    /**
     * Main method to check if a binary tree is a valid BST
     *
     * @param root The root node of the binary tree
     * @return true if the tree is a valid BST, false otherwise
     */
    public boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    /**
     * Helper method to recursively validate the BST properties
     *
     * @param node The current node being validated
     * @param lower The lower bound value that the node's value must be greater
     * than
     * @param upper The upper bound value that the node's value must be less
     * than
     * @return true if the subtree rooted at node is a valid BST, false
     * otherwise
     */
    private boolean validate(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true; // A null node is always valid
        }

        if (node.val <= lower || node.val >= upper) {
            return false; // The current node's value violates the BST property
        }

        // Recursively validate the left and right subtrees
        return validate(node.left, lower, node.val) && validate(node.right, node.val, upper);
    }

    /**
     * Test cases to verify the BST validation logic
     */
    public void runTests() {
        // Test Case 1: Valid BST
        //      2
        //     / \
        //    1   3
        TreeNode test1 = new TreeNode(2);
        test1.left = new TreeNode(1);
        test1.right = new TreeNode(3);
        assert isValidBST(test1) == true : "Test Case 1 Failed";

        // Test Case 2: Invalid BST
        //      5
        //     / \
        //    1   4
        //       / \
        //      3   6
        TreeNode test2 = new TreeNode(5);
        test2.left = new TreeNode(1);
        test2.right = new TreeNode(4);
        test2.right.left = new TreeNode(3);
        test2.right.right = new TreeNode(6);
        assert isValidBST(test2) == false : "Test Case 2 Failed";

        // Test Case 3: Single node (valid BST)
        TreeNode test3 = new TreeNode(1);
        assert isValidBST(test3) == true : "Test Case 3 Failed";

        // Test Case 4: Empty tree (valid BST)
        assert isValidBST(null) == true : "Test Case 4 Failed";

        // Test Case 5: BST with duplicate values (invalid)
        //      2
        //     / \
        //    2   2
        TreeNode test5 = new TreeNode(2);
        test5.left = new TreeNode(2);
        test5.right = new TreeNode(2);
        assert isValidBST(test5) == false : "Test Case 5 Failed";

        System.out.println("All test cases passed successfully!");
    }
}
