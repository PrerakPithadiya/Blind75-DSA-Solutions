
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.LinkedList;
import java.util.Queue;

/**
 * A class that provides methods to serialize a binary tree to a string and
 * deserialize it back to a tree structure. This implementation uses a
 * level-order (breadth-first) traversal approach.
 */
class Codec {

    /**
     * Serializes a binary tree to a string representation. The serialization
     * format uses comma-separated values in level-order traversal, where null
     * nodes are represented as "null".
     *
     * @param root The root node of the binary tree to serialize
     * @return A string representation of the binary tree
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        return sb.toString();
    }

    /**
     * Deserializes a string representation back to a binary tree. The input
     * string should be in the format produced by the serialize method.
     *
     * @param data The string representation of the binary tree
     * @return The root node of the reconstructed binary tree
     * @throws NumberFormatException if the input string contains invalid number
     * formats
     */
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) {
            return null;
        }
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        for (int i = 1; i < nodes.length; i++) {
            TreeNode parent = queue.poll();
            if (!nodes[i].equals("null")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = left;
                queue.add(left);
            }
            if (++i < nodes.length && !nodes[i].equals("null")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    /**
     * Test cases demonstrating the usage of the Codec class.
     */
    public static void main(String[] args) {
        Codec codec = new Codec();

        // Test Case 1: Normal binary tree
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(3);
        root1.left.left = new TreeNode(4);
        String serialized1 = codec.serialize(root1);
        TreeNode deserialized1 = codec.deserialize(serialized1);
        assert isIdentical(root1, deserialized1) : "Test Case 1 Failed";

        // Test Case 2: Empty tree
        TreeNode root2 = null;
        String serialized2 = codec.serialize(root2);
        TreeNode deserialized2 = codec.deserialize(serialized2);
        assert deserialized2 == null : "Test Case 2 Failed";

        // Test Case 3: Single node tree
        TreeNode root3 = new TreeNode(1);
        String serialized3 = codec.serialize(root3);
        TreeNode deserialized3 = codec.deserialize(serialized3);
        assert isIdentical(root3, deserialized3) : "Test Case 3 Failed";

        System.out.println("All test cases passed!");
    }

    /**
     * Helper method to check if two binary trees are identical.
     *
     * @param a First binary tree
     * @param b Second binary tree
     * @return true if the trees are identical, false otherwise
     */
    private static boolean isIdentical(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a == null || b == null) {
            return false;
        }
        return a.val == b.val
                && isIdentical(a.left, b.left)
                && isIdentical(a.right, b.right);
    }
}
