
/**
 * Definition for a binary search tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
/**
 * Solution for finding the Lowest Common Ancestor (LCA) in a Binary Search Tree (BST)
 *
 * Problem Description:
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
 * The LCA is defined between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).
 *
 * Time Complexity: O(h) where h is the height of the tree
 * Space Complexity: O(1) as we only use constant extra space
 */
class Solution {

    /**
     * Finds the lowest common ancestor of two nodes in a BST
     *
     * @param root The root node of the binary search tree
     * @param p First node to find LCA for
     * @param q Second node to find LCA for
     * @return TreeNode representing the lowest common ancestor
     * @throws NullPointerException if root, p, or q is null
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Input validation
        if (root == null || p == null || q == null) {
            throw new NullPointerException("Input nodes cannot be null");
        }

        // Start from the root node of the tree
        TreeNode currentNode = root;

        // Traverse the tree
        while (currentNode != null) {
            // If both p and q are greater than parent
            if (p.val > currentNode.val && q.val > currentNode.val) {
                currentNode = currentNode.right;
            } // If both p and q are lesser than parent
            else if (p.val < currentNode.val && q.val < currentNode.val) {
                currentNode = currentNode.left;
            } // We have found the split point, i.e. the LCA node.
            else {
                return currentNode;
            }
        }
        return null;
    }

    /**
     * Test cases for the lowestCommonAncestor method
     */
    public void testLowestCommonAncestor() {
        // Test Case 1: Normal BST
        //       6
        //     /   \
        //    2     8
        //   / \   / \
        //  0   4 7   9
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);

        assert lowestCommonAncestor(root, root.left, root.right).val == 6;  // LCA of 2 and 8 is 6
        assert lowestCommonAncestor(root, root.left, root.left.right).val == 2;  // LCA of 2 and 4 is 2

        // Test Case 2: Linear BST (straight line)
        //      5
        //     /
        //    4
        //   /
        //  3
        TreeNode linearRoot = new TreeNode(5);
        linearRoot.left = new TreeNode(4);
        linearRoot.left.left = new TreeNode(3);

        assert lowestCommonAncestor(linearRoot, linearRoot.left, linearRoot).val == 5;  // LCA of 4 and 5 is 5

        // Test Case 3: Single node BST
        TreeNode singleNode = new TreeNode(1);
        assert lowestCommonAncestor(singleNode, singleNode, singleNode).val == 1;  // LCA of 1 and 1 is 1
    }
}
