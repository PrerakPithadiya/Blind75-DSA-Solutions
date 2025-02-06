
/**
 * Implementation of a Trie (Prefix Tree) data structure.
 * A Trie is an efficient information retrieval data structure used to store and retrieve strings.
 */
class TrieNode {

    /**
     * Array to store child nodes for each letter of the alphabet
     */
    private final TrieNode[] children;

    /**
     * Returns the children of this TrieNode.
     *
     * @return the children of this TrieNode
     */
    public TrieNode[] getChildren() {
        return children;
    }

    /**
     * Flag to mark if this node represents the end of a word
     */
    private boolean isEndOfWord;

    /**
     * Initializes a new TrieNode with space for 26 children (English alphabet)
     */
    public TrieNode() {
        children = new TrieNode[26]; // 26 letters of the English alphabet
        isEndOfWord = false;
    }

    public boolean isEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord(boolean endOfWord) {
        isEndOfWord = endOfWord;
    }
}

/**
 * Trie data structure implementation supporting insert, search, and prefix
 * operations.
 */
class Trie {

    /**
     * Root node of the Trie
     */
    private final TrieNode root;

    /**
     * Initializes an empty Trie with a root node.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie. Time complexity: O(n) where n is the length
     * of the word Space complexity: O(n)
     *
     * @param word the word to insert into the trie
     * @throws IllegalArgumentException if word is null or contains
     * non-lowercase letters
     */
    public void insert(String word) {
        if (word == null || !word.matches("[a-z]+")) {
            throw new IllegalArgumentException("Word must contain only lowercase letters");
        }

        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.getChildren()[index] == null) {
                node.getChildren()[index] = new TrieNode();
            }
            node = node.getChildren()[index];
        }
        node.setEndOfWord(true);
    }

    /**
     * Searches for a complete word in the trie. Time complexity: O(n) where n
     * is the length of the word Space complexity: O(1)
     *
     * @param word the word to search for
     * @return true if the word exists in the trie, false otherwise
     * @throws IllegalArgumentException if word is null or contains
     * non-lowercase letters
     */
    public boolean search(String word) {
        if (word == null || !word.matches("[a-z]+")) {
            throw new IllegalArgumentException("Word must contain only lowercase letters");
        }

        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return node.isEndOfWord();
    }

    /**
     * Checks if there is any word in the trie that starts with the given
     * prefix. Time complexity: O(n) where n is the length of the prefix Space
     * complexity: O(1)
     *
     * @param prefix the prefix to search for
     * @return true if any word in the trie starts with the given prefix, false
     * otherwise
     * @throws IllegalArgumentException if prefix is null or contains
     * non-lowercase letters
     */
    public boolean startsWith(String prefix) {
        if (prefix == null || !prefix.matches("[a-z]+")) {
            throw new IllegalArgumentException("Prefix must contain only lowercase letters");
        }

        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            int index = ch - 'a';
            if (node.getChildren()[index] == null) {
                return false;
            }
            node = node.getChildren()[index];
        }
        return true;
    }

    /**
     * Main method with test cases demonstrating Trie functionality
     */
    public static void main(String[] args) {
        // Create a new Trie instance
        Trie trie = new Trie();

        // Test case 1: Basic insertion and search
        trie.insert("apple");
        assert trie.search("apple") : "Test 1.1 failed: 'apple' should be found";
        assert !trie.search("app") : "Test 1.2 failed: 'app' should not be found";
        assert trie.startsWith("app") : "Test 1.3 failed: prefix 'app' should be found";

        // Test case 2: Multiple insertions
        trie.insert("app");
        assert trie.search("app") : "Test 2.1 failed: 'app' should be found after insertion";

        // Test case 3: Prefix testing
        trie.insert("apartment");
        assert trie.startsWith("ap") : "Test 3.1 failed: prefix 'ap' should be found";
        assert !trie.startsWith("b") : "Test 3.2 failed: prefix 'b' should not be found";

        // Test case 4: Empty string handling
        try {
            trie.insert("");
            assert false : "Test 4.1 failed: Empty string should throw exception";
        } catch (IllegalArgumentException e) {
            // Expected behavior
        }

        // Test case 5: Case sensitivity
        try {
            trie.insert("Apple");
            assert false : "Test 5.1 failed: Uppercase letters should throw exception";
        } catch (IllegalArgumentException e) {
            // Expected behavior
        }

        System.out.println("All test cases passed successfully!");
    }
}
