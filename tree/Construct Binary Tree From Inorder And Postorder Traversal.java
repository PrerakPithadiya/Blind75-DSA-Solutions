
import java.util.HashMap;
import java.util.Map;

/**
 * Solution for constructing a binary tree from inorder and postorder
 * traversals. Time Complexity: O(n) where n is the number of nodes Space
 * Complexity: O(n) for storing the hashmap and recursion stack
 */
class Solution {

    /**
     * Map to store the indices of values in inorder traversal for O(1) lookup
     */
    private Map<Integer, Integer> inorderMap;

    /**
     * Builds a binary tree from given inorder and postorder traversals.
     *
     * @param inorder Array containing inorder traversal of the tree
     * @param postorder Array containing postorder traversal of the tree
     * @return Root node of the constructed binary tree
     * @throws IllegalArgumentException if input arrays are null or have
     * different lengths
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            throw new IllegalArgumentException("Input arrays cannot be null");
        }
        if (inorder.length != postorder.length) {
            throw new IllegalArgumentException("Inorder and postorder arrays must have the same length");
        }

        // Build a hashmap to store value -> index relations for inorder traversal
        inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildSubtree(postorder, postorder.length - 1, 0, inorder.length - 1);
    }

    /**
     * Recursively builds a subtree using the postorder and inorder traversals.
     *
     * @param postorder The postorder traversal array
     * @param postorderIndex Current index in postorder array (root of current
     * subtree)
     * @param inorderLeft Left boundary of current subtree in inorder array
     * @param inorderRight Right boundary of current subtree in inorder array
     * @return Root node of the constructed subtree
     */
    private TreeNode buildSubtree(int[] postorder, int postorderIndex, int inorderLeft, int inorderRight) {
        // Base case: if there are no elements to construct the subtree
        if (inorderLeft > inorderRight || postorderIndex < 0) {
            return null;
        }

        // The current root is the last element in the postorder traversal
        int rootValue = postorder[postorderIndex];
        TreeNode root = new TreeNode(rootValue);

        // Get the index of the current root in the inorder traversal
        int inorderIndex = inorderMap.get(rootValue);

        // Calculate sizes of left and right subtrees
        int rightSubtreeSize = inorderRight - inorderIndex;

        // Recursively build the right and left subtrees
        root.right = buildSubtree(postorder, postorderIndex - 1, inorderIndex + 1, inorderRight);
        root.left = buildSubtree(postorder, postorderIndex - rightSubtreeSize - 1, inorderLeft, inorderIndex - 1);

        return root;
    }

    /**
     * Test cases for the solution.
     */
    public void runTests() {
        // Test Case 1: Normal binary tree
        int[] inorder1 = {9, 3, 15, 20, 7};
        int[] postorder1 = {9, 15, 7, 20, 3};
        TreeNode result1 = buildTree(inorder1, postorder1);
        assert result1.val == 3;
        assert result1.left.val == 9;
        assert result1.right.val == 20;

        // Test Case 2: Single node tree
        int[] inorder2 = {1};
        int[] postorder2 = {1};
        TreeNode result2 = buildTree(inorder2, postorder2);
        assert result2.val == 1;

        // Test Case 3: Empty tree
        int[] inorder3 = {};
        int[] postorder3 = {};
        TreeNode result3 = buildTree(inorder3, postorder3);
        assert result3 == null;

        // Test Case 4: Linear tree (only right children)
        int[] inorder4 = {1, 2, 3, 4};
        int[] postorder4 = {4, 3, 2, 1};
        TreeNode result4 = buildTree(inorder4, postorder4);
        assert result4.val == 1;
        assert result4.right.val == 2;
        assert result4.right.right.val == 3;

        System.out.println("All test cases passed!");
    }
}
