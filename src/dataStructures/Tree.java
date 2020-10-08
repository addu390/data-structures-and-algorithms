package dataStructures;

import dataStructures.impl.TreeNode;

/**
 * Intro:
 * 1. A hierarchical data structure.
 * 2. Tree is a non-linear data structure.
 * 3. Every items of a tree is called Node and the Top node is called root node.
 * 4. Nodes at the bottom without children are called leaf nodes.
 * 5. Nodes below a node are called children
 * 6. Degree of a node: Number of children.
 *
 * Applications of tree?
 * 1. To represent hierarchical data (such as a folder structure)
 *      HTML/XML tags - nested tags.
 * 2. Binary Search Trees - Nodes with a max of 2 children.
 * 3. Binary heap (Priority queues)
 * 4. B and B+ Trees in DBMS
 * 5. Spanning and Shortest path in computer networks
 * 6. Parse Tree and Expression Tree in Compilers.
 */
public class Tree {

    /**
     * Binary tree: Degree of the node is at most 2 (0, 1 or 2).
     * Hence every node has 3 field: data, reference to child 1 and 2.
     *
     * Traversal of a tree:
     * 1. Breath first - traverse al horizontal/breath level.
     * 2. Depth first - Inorder (left child, root, right child)
     *                  Preorder (root, left, right)
     *                  Postorder (left, right, root)
     */

    public static void main(String[] args) {
        TreeNode node = new TreeNode(10);
        node.left = new TreeNode(20);
        node.right = new TreeNode(30);

        inorder(node);

    }

    public static void inorder(TreeNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.data);
            inorder(node.right);
        }
    }

}
