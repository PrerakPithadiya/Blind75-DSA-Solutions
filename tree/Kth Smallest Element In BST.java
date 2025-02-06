
/**
 * Definition for a binary search tree node.
 * This class represents a node in a Binary Search Tree data structure.
 */
class TreeNode {

    int val;
    TreeNode left, right;

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
 * Solution class to find the kth smallest element in a Binary Search Tree (BST)
 * Time Complexity: O(N) where N is the number of nodes in the tree Space
 * Complexity: O(H) where H is the height of the tree due to recursion stack
 */
class Solution {

    private int count = 0;
    private int result = -1;

    /**
     * Finds the kth smallest element in the BST
     *
     * @param root The root node of the BST
     * @param k The position of the element to find (1-based)
     * @return The kth smallest element in the BST
     * @throws IllegalArgumentException if k is less than 1 or greater than the
     * tree size
     */
    public int kthSmallest(TreeNode root, int k) {
        if (k < 1) {
            throw new IllegalArgumentException("k must be greater than 0");
        }

        count = 0;
        result = -1;
        inOrderTraversal(root, k);

        if (result == -1) {
            throw new IllegalArgumentException("k is larger than the tree size");
        }

        return result;
    }

    /**
     * Performs an inorder traversal of the BST to find the kth smallest element
     *
     * @param node The current node in the traversal
     * @param k The target position to find
     */
    private void inOrderTraversal(TreeNode node, int k) {
        if (node == null || count >= k) {
            return;
        }

        inOrderTraversal(node.left, k);

        count++;
        if (count == k) {
            result = node.val;
            return;
        }

        inOrderTraversal(node.right, k);
    }

    /**
     * Test cases for the kthSmallest method
     */
    public static void runTests() {
        Solution solution = new Solution();

        // Test Case 1: Normal BST
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(4);
        root1.left.right = new TreeNode(2);
        int result1 = solution.kthSmallest(root1, 1);
        assert result1 == 1 : "Test Case 1.1 failed";
        int result2 = solution.kthSmallest(root1, 2);
        assert result2 == 2 : "Test Case 1.2 failed";
        int result3 = solution.kthSmallest(root1, 3);
        assert result3 == 3 : "Test Case 1.3 failed";

        // Test Case 2: Linear BST (only right children)
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
        root2.right.right = new TreeNode(3);
        int result4 = solution.kthSmallest(root2, 2);
        assert result4 == 2 : "Test Case 2 failed";

        // Test Case 3: Single node BST
        TreeNode root3 = new TreeNode(1);
        int result5 = solution.kthSmallest(root3, 1);
        assert result5 == 1 : "Test Case 3 failed";

        // Test Case 4: Error cases
        try {
            solution.kthSmallest(root1, 0);
            assert false : "Test Case 4.1 failed: Should throw exception for k < 1";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        try {
            solution.kthSmallest(root1, 10);
            assert false : "Test Case 4.2 failed: Should throw exception for k > tree size";
        } catch (IllegalArgumentException e) {
            // Expected exception
        }

        System.out.println("All test cases passed!");
    }
}
