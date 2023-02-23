package problems.blindAll.tree;

public class DiameterOfBinaryTree {

    // Solve with DFS
    // Diameter is: Max of Left + right;
    public static int diameterOfBinaryTree(TreeNode root) {
        // Since primitive types are not by reference, using an array instead.
        int[] result = new int[1];
        dfs(root, result);
        return result[0];
    }

    private static int dfs(TreeNode root, int[] max) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = dfs(root.left, max);
        int right = dfs(root.right, max);

        max[0] = Math.max(max[0], left + right);

        return 1 + Math.max(left, right);
    }
}
