package problems.blindAll.tree;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> set1 = new ArrayList<>();
        List<Integer> set2 = new ArrayList<>();

        dfs(root1, set1);
        dfs(root2, set2);

        if (set1.equals(set2)) {
            return true;
        }

        return false;
    }

    private void dfs(TreeNode node, List<Integer> set) {
        if (node != null) {
            if (node.left == null && node.right == null) {
                set.add(node.val);
            }

            dfs(node.left, set);
            dfs(node.right, set);
        }
    }
}
