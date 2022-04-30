package problems.leetcode.tree;

public class MinimumDepth {

    // The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
    // A leaf is a node with no children.
    public int minDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 1;
        }
        else if (root.left == null) {
            return 1 + minDepthDFS(root.right);
        }
        else if (root.right == null) {
            return 1 + minDepthDFS(root.left);
        } else {
            return 1 + Math.min(minDepthDFS(root.left), minDepthDFS(root.right));
        }
    }
}
