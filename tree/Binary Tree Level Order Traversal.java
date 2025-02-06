
import java.util.*;

/**
 * Definition for a binary tree node. This class represents a node in a binary
 * tree data structure. Each node contains an integer value and references to
 * left and right child nodes.
 */
class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    /**
     * Constructor with value initialization
     *
     * @param val integer value to be stored in the node
     */
    TreeNode(int val) {
        this.val = val;
    }

}

/**
 * Solution class for Binary Tree Level Order Traversal problem This class
 * provides implementation for level-order traversal of a binary tree
 */
class BinaryTreeLevelOrderTraversal {

    /**
     * Performs level-order traversal of a binary tree
     *
     * @param root the root node of the binary tree
     * @return List of lists containing integers at each level of the tree
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevel.add(currentNode.val);

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            result.add(currentLevel);
        }

        return result;
    }

    /**
     * Test cases to verify the functionality of levelOrder method
     */
    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal solution = new BinaryTreeLevelOrderTraversal();

        // Test Case 1: Normal binary tree
        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);
        System.out.println("Test Case 1 Result: " + solution.levelOrder(root1));
        // Expected output: [[3], [9, 20], [15, 7]]

        // Test Case 2: Empty tree
        TreeNode root2 = null;
        System.out.println("Test Case 2 Result: " + solution.levelOrder(root2));
        // Expected output: []

        // Test Case 3: Single node tree
        TreeNode root3 = new TreeNode(1);
        System.out.println("Test Case 3 Result: " + solution.levelOrder(root3));
        // Expected output: [[1]]

        // Test Case 4: Complete binary tree
        TreeNode root4 = new TreeNode(1);
        root4.left = new TreeNode(2);
        root4.right = new TreeNode(3);
        root4.left.left = new TreeNode(4);
        root4.left.right = new TreeNode(5);
        root4.right.left = new TreeNode(6);
        root4.right.right = new TreeNode(7);
        System.out.println("Test Case 4 Result: " + solution.levelOrder(root4));
        // Expected output: [[1], [2, 3], [4, 5, 6, 7]]
    }
}
