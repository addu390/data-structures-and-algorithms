package problems.leetcode.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Pronounced "Try", Prefix Tree - Commonly used for autocomplete and spellchecker.
// Efficiently store strings.
// Creation: Space: O(alphabet_size(26) * average key length * number of words)
// Time: O(average key length) for all 3 operations (Search, Insert Delete).
public class Trie {
    Node root;

    // Every node will have characters A-Z as children (nodes).
    public Trie() {
        root = new Node('\0'); // Dummy node
    }

    public void insert(String word) {
        Node current = root;
        for (char c: word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new Node(c));
            }
            current = current.children.get(c);
        }
        // Marking the last node.
        current.isWord = true;

    }

    public boolean search(String word) {
        Node lastNode = getLast(word);
        return (lastNode != null && lastNode.isWord);
    }

    public List<String> startsWith(String prefix) {
        List<String> words = new ArrayList<>();
        Node lastNode = getLast(prefix);

        if (lastNode != null) {
            if (!lastNode.children.isEmpty()) {
                findRest(prefix, lastNode, words);
            } else {
                words.add(prefix);
            }
        }
        return words;
    }

    private void findRest(String prefix, Node node, List<String> words) {
        if (node.isWord) {
            words.add(prefix);
        }
        if (node.children.isEmpty()) {
            return;
        }

        for (Character c: node.children.keySet()) {
            findRest(prefix + c, node.children.get(c), words);
        }
    }

    private Node getLast(String word) {
        Node current = root;
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return null;
            }

            current = current.children.get(c);
        }
        return current;
    }

    class Node {
        private char value;
        private boolean isWord;
        private HashMap<Character, Node> children;

        public Node(char value) {
            this.value = value;
            this.isWord = false;
            this.children = new HashMap<>();
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("appa");
        trie.insert("appx");
        trie.insert("appyb");

        System.out.print(trie.startsWith("appa"));
    }
}
