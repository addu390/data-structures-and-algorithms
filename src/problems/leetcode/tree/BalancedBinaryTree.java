package problems.leetcode.tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    // After recursion, the height of left and right is eventually decided at level 1 (level after root).
    // 1 + Max(left, right), as the max length of left or right decides the height of that subtree.
    // +1 to include the current node at each level.
    private int dfs(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        if (Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
