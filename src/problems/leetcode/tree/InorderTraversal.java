package problems.leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    public static void dfs(TreeNode node, List<Integer> result) {
        if (node != null) {
            dfs(node.left, result);
            result.add(node.val);
            dfs(node.right, result);
        }
    }
}
