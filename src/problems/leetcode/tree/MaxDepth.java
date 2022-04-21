package problems.leetcode.tree;

import java.util.Map;

// Recursive DFS (Depth First Search)
// Iterative DFS
// BFS (Breath First Search)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 1;
        }
        else {
            return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
        }

    }
}
