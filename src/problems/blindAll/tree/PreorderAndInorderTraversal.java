package problems.blindAll.tree;

// Construct Binary Tree from Preorder and Inorder Traversal
// Preorder: Root, Left, Right
// Inorder: Left, Root, Right.

import java.util.Arrays;

// 1. First value in pre-order is the root.
// 2. Find root in Inorder (left to right), the left of it is the left of the root.
// 3 The inorder array tells us how to slice/cut the preorder array (number of nodes in left and right).

// Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
public class PreorderAndInorderTraversal {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);
        int mid = indexOfIntArray(inorder, preorder[0]);

        // copyOfRange works o position and not index
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, mid + 1), Arrays.copyOfRange(inorder, 0, mid));
        root.right = buildTree(Arrays.copyOfRange(preorder, mid + 1, preorder.length), Arrays.copyOfRange(inorder, mid + 1, preorder.length));

        return root;
    }

    public static void main(String[] args) {
        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
    }

    private static int indexOfIntArray(int[] array, int key) {
        int result = -1;
        for (int i = 0; i < array.length; ++i) {
            if (key == array[i]) {
                result = i;
                break;
            }
        }
        return result;
    }
}
