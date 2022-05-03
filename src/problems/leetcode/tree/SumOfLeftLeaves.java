package problems.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SumOfLeftLeaves {
    public static int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int sum = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.remove();
                if (node != null) {
                    if (i % 2 == 0) {
                        if (node.left == null && node.right == null) {
                            sum = sum + node.val;
                        }
                    }
                    queue.add(node.left);
                    queue.add(node.right);
                }

            }
        }

        return sum;

    }

    public static int sumOfLeftLeaves2(TreeNode root) {
        return checkSum(root, 0, false);
    }


    private static int checkSum(TreeNode node, int sum, boolean isLeft) {
        if(node == null) {
            return 0;
        } else if(node.left == null && node.right == null && isLeft) {
            return node.val;
        }
        return checkSum(node.left, sum, true) + checkSum(node.right, sum, false);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        sumOfLeftLeaves(node);
        sumOfLeftLeaves2(node);
    }
}
