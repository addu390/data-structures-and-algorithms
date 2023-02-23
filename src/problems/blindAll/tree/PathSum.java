package problems.blindAll.tree;

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, targetSum, 0);
    }

    public static boolean dfs(TreeNode root, int targetSum, int currentSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            if (targetSum == (currentSum + root.val)) {
                return true;
            }
        }

        return dfs(root.left, targetSum, currentSum + root.val) || dfs(root.right, targetSum, currentSum + root.val);
    }
}
