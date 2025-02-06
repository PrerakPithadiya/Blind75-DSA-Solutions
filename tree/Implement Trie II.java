
import java.util.HashMap;
import java.util.Map;

/**
 * Implementation of a Trie (Prefix Tree) data structure with word counting
 * functionality. This class provides methods to insert words, count
 * occurrences, and track prefixes.
 */
class ImplementTrieII {

    /**
     * Inner class representing a node in the Trie. Each node contains a map of
     * children nodes, count of words ending at this node, and count of words
     * having this node as prefix.
     */
    private class TrieNode {

        final Map<Character, TrieNode> children;
        int countEnd;
        int countPrefix;

        TrieNode() {
            children = new HashMap<>();
            countEnd = 0;
            countPrefix = 0;
        }
    }

    private final TrieNode root;

    /**
     * Initializes an empty Trie data structure.
     */
    public ImplementTrieII() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie and updates the prefix counts.
     *
     * @param word the word to be inserted
     */
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.countPrefix++;
        }
        node.countEnd++;
    }

    /**
     * Counts the number of occurrences of a specific word in the trie.
     *
     * @param word the word to count
     * @return the number of times the word appears in the trie
     */
    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return 0;
            }
            node = node.children.get(ch);
        }
        return node.countEnd;
    }

    /**
     * Counts the number of words that start with a given prefix.
     *
     * @param prefix the prefix to search for
     * @return the number of words that start with the given prefix
     */
    public int countWordsStartingWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.children.containsKey(ch)) {
                return 0;
            }
            node = node.children.get(ch);
        }
        return node.countPrefix;
    }

    /**
     * Removes one occurrence of a word from the trie. If it's the last
     * occurrence of a prefix, removes the corresponding nodes.
     *
     * @param word the word to be removed
     */
    public void erase(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            TrieNode nextNode = node.children.get(ch);
            if (nextNode.countPrefix == 1) {
                node.children.remove(ch);
                return;
            } else {
                nextNode.countPrefix--;
                node = nextNode;
            }
        }
        node.countEnd--;
    }

    /**
     * Main method with test cases demonstrating the Trie functionality.
     */
    public static void main(String[] args) {
        // Test case 1: Basic operations
        ImplementTrieII trie1 = new ImplementTrieII();
        trie1.insert("apple");
        trie1.insert("apple");
        assert trie1.countWordsEqualTo("apple") == 2 : "Test case 1 failed";
        assert trie1.countWordsStartingWith("app") == 2 : "Test case 1 failed";
        trie1.erase("apple");
        assert trie1.countWordsEqualTo("apple") == 1 : "Test case 1 failed";

        // Test case 2: Multiple words with same prefix
        ImplementTrieII trie2 = new ImplementTrieII();
        trie2.insert("car");
        trie2.insert("cat");
        trie2.insert("cart");
        assert trie2.countWordsStartingWith("car") == 2 : "Test case 2 failed";
        assert trie2.countWordsEqualTo("car") == 1 : "Test case 2 failed";

        // Test case 3: Empty string and non-existent words
        ImplementTrieII trie3 = new ImplementTrieII();
        trie3.insert("");
        assert trie3.countWordsEqualTo("") == 1 : "Test case 3 failed";
        assert trie3.countWordsEqualTo("notfound") == 0 : "Test case 3 failed";
        assert trie3.countWordsStartingWith("any") == 0 : "Test case 3 failed";

        System.out.println("All test cases passed!");
    }
}
