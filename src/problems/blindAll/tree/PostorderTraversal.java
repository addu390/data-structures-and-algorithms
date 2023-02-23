package problems.blindAll.tree;

import java.util.ArrayList;
import java.util.List;

public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        dfs(root, result);
        return result;
    }

    private void dfs(TreeNode node, List<Integer> result) {
        if (node != null) {
            dfs(node.left, result);
            dfs(node.right, result);
            result.add(node.val);
        }
    }
}
