
import java.util.LinkedList;
import java.util.Queue;

/**
 * Definition for a binary tree node.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    /**
     * Helper method to print the tree in level order
     */
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.print(node.val + " ");
                queue.add(node.left);
                queue.add(node.right);
            } else {
                System.out.print("null ");
            }
        }
        System.out.println();
    }
}

/**
 * Solution class for inverting a binary tree Time Complexity: O(n) where n is
 * the number of nodes in the tree Space Complexity: O(h) where h is the height
 * of the tree due to recursion stack
 */
class Solution {

    /**
     * Inverts a binary tree by swapping left and right children of each node
     *
     * @param root The root node of the binary tree to be inverted
     * @return The root node of the inverted binary tree
     */
    public TreeNode invertTree(TreeNode root) {
        // Base case: if the node is null, return null
        if (root == null) {
            return null;
        }

        // Recursively invert the left and right subtrees
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // Swap the left and right children
        root.right = left;
        root.left = right;

        // Return the current root node after inversion
        return root;
    }

    /**
     * Main method to test the invertTree function
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Normal binary tree
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);
        TreeNode result1 = solution.invertTree(root1);
        // Expected: [4,7,2,9,6,3,1]
        TreeNode.printTree(result1);

        // Test Case 2: Empty tree
        TreeNode root2 = null;
        // Expected: null
        TreeNode.printTree(root2);
        // Expected: null

        // Test Case 3: Single node tree
        // Test Case 3: Single node tree
        TreeNode root3 = new TreeNode(1);
        TreeNode result3 = solution.invertTree(root3);
        // Expected: [1]
        TreeNode.printTree(result3);

        // Test Case 4: Two level tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        TreeNode result4 = solution.invertTree(root4);
        TreeNode.printTree(result4);
        // Expected: [1,3,2]
        root4.right = new TreeNode(3);
        result4 = solution.invertTree(root4);
        TreeNode.printTree(result4);
        // Expected: [1,3,2]
    }
}
