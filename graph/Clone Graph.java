package graph;

import java.util.*;

/**
 * Clone Graph - Creates a deep copy of an undirected graph
 *
 * Problem Description: Given a reference of a node in a connected undirected
 * graph, return a deep copy (clone) of the graph. Each node in the graph
 * contains a value (int) and a list of its neighbors (List[Node]).
 *
 * Time Complexity: O(N + E) where N is the number of nodes and E is the number
 * of edges Space Complexity: O(N) for the hash map to store visited nodes
 */
class Solution {

    /**
     * Node class representing each vertex in the graph
     */
    static class Node {

        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    /**
     * Main method to clone the graph
     *
     * @param node Reference to the source graph node
     * @return Reference to the cloned graph node
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Map<Node, Node> visited = new HashMap<>();
        return cloneGraphDFS(node, visited);
    }

    /**
     * Helper method that performs DFS to clone the graph
     *
     * @param node Current node being processed
     * @param visited Map to keep track of cloned nodes
     * @return Reference to the cloned node
     */
    private Node cloneGraphDFS(Node node, Map<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        Node cloneNode = new Node(node.val);
        visited.put(node, cloneNode);

        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphDFS(neighbor, visited));
        }

        return cloneNode;
    }

    /**
     * Test cases to verify the functionality
     */
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test Case 1: Single node
        Node node1 = new Node(1);
        Node result1 = solution.cloneGraph(node1);
        System.out.println("Test Case 1 - Single Node: " + (result1.val == 1));

        // Test Case 2: Two connected nodes
        Node node2 = new Node(1);
        Node node3 = new Node(2);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        Node result2 = solution.cloneGraph(node2);
        System.out.println("Test Case 2 - Two Connected Nodes: "
                + (result2.val == 1 && result2.neighbors.get(0).val == 2));

        // Test Case 3: Null input
        Node result3 = solution.cloneGraph(null);
        System.out.println("Test Case 3 - Null Input: " + (result3 == null));

        // Test Case 4: Cycle with four nodes
        Node node4 = new Node(1);
        Node node5 = new Node(2);
        Node node6 = new Node(3);
        Node node7 = new Node(4);

        node4.neighbors.add(node5);
        node4.neighbors.add(node7);
        node5.neighbors.add(node4);
        node5.neighbors.add(node6);
        node6.neighbors.add(node5);
        node6.neighbors.add(node7);
        node7.neighbors.add(node4);
        node7.neighbors.add(node6);

        Node result4 = solution.cloneGraph(node4);
        System.out.println("Test Case 4 - Four Node Cycle: "
                + (result4.val == 1 && result4.neighbors.size() == 2));
    }
}
