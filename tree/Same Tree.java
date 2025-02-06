
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

}

/**
 * Solution class for checking if two binary trees are identical. Two binary
 * trees are considered the same if they are structurally identical and the
 * nodes have the same value.
 */
class Solution {

    /**
     * Determines if two binary trees are identical in structure and values.
     *
     * @param p The root node of the first binary tree
     * @param q The root node of the second binary tree
     * @return true if the trees are identical, false otherwise
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case: both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // If one of the nodes is null, or if the values don't match, return false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }

        // Recursively check the left and right subtrees
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * Main method to test the solution with various test cases.
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Identical trees
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Test Case 1 - Expected: true, Actual: " + solution.isSameTree(p1, q1));

        // Test Case 2: Different values
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        TreeNode q2 = new TreeNode(1);
        q2.left = new TreeNode(3);

        System.out.println("Test Case 2 - Expected: false, Actual: " + solution.isSameTree(p2, q2));

        // Test Case 3: Different structures
        TreeNode p3 = new TreeNode(1);
        p3.left = new TreeNode(2);

        TreeNode q3 = new TreeNode(1);
        q3.right = new TreeNode(2);

        System.out.println("Test Case 3 - Expected: false, Actual: " + solution.isSameTree(p3, q3));

        // Test Case 4: Empty trees
        System.out.println("Test Case 4 - Expected: true, Actual: " + solution.isSameTree(null, null));

        // Test Case 5: One empty tree
        TreeNode p5 = new TreeNode(1);
        System.out.println("Test Case 5 - Expected: false, Actual: " + solution.isSameTree(p5, null));
    }
}
