package problems.blindAll.tree;

import java.util.ArrayList;
import java.util.List;

public class PreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node != null) {
            result.add(node.val);
            dfs(node.left, result);
            dfs(node.right, result);
        }
    }
}
