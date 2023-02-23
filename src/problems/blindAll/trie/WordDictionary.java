package problems.blindAll.trie;

import java.util.HashMap;

public class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node('\0');
    }

    public void addWord(String word) {
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
        return search(word, root);
    }

    public boolean search(String word, Node node) {
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);

            if (!node.children.containsKey(c)) {

                if (c == '.') {
                    for(char cc: node.children.keySet()) {
                        Node child = node.children.get(cc);
                        if (search(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }

                return false;

            } else {
                node = node.children.get(c);
            }
        }

        return node.isWord;
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
}
