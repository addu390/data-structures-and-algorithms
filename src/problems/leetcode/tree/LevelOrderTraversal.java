package problems.leetcode.tree;

import java.util.*;

public class LevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.right == null && root.left == null) {
            return Collections.singletonList(Collections.singletonList(root.val));
        }

        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> levelArray = new ArrayList<>();
            // Because updating the queue changes the queue.size();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode local = queue.remove();

                levelArray.add(local.val);

                if (local.left != null) {
                    queue.add(local.left);
                }
                if (local.right != null) {
                    queue.add(local.right);
                }
            }
            result.add(levelArray);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        levelOrder(root);
    }
}
