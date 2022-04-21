package problems.leetcode.tree;

import java.util.*;

// Recursive DFS (Depth First Search)
// Iterative DFS
// BFS (Breath First Search)
class StackNode {
    TreeNode node;
    Integer depth;

    StackNode(TreeNode node, Integer depth) {
        this.node = node;
        this.depth = depth;
    }
}
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
    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        else if (root.left == null && root.right == null) {
            return 1;
        }
        else {
            return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
        }

    }

    public int maxDepthIDFS(TreeNode root) {
        // Need to use a stack - depicting the working of the call stack.
        if (root == null) {
            return 0;
        }

        Stack<StackNode> stack = new Stack<>();
        stack.add(new StackNode(root, 1));

        int result = 1;

        while (!stack.isEmpty()) {
            StackNode stackNode = stack.pop();
            if (Objects.nonNull(stackNode) && Objects.nonNull(stackNode.node)) {
                result = Math.max(result, stackNode.depth);
                stack.add(new StackNode(stackNode.node.left, stackNode.depth + 1));
                stack.add(new StackNode(stackNode.node.right, stackNode.depth + 1));
            }
        }
        return result;
    }

    public int maxDepthIBFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode node = queue.remove();

                if (node.right != null) {
                    queue.add(node.right);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
            }
            level = level + 1;
        }
        return level;
    }
}
