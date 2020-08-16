package swe.trees;

import swe.helpers.Helpers;
import swe.helpers.ListNode;
import swe.helpers.TreeNode;

import java.util.Arrays;

public class SymmetricTree {

    public static void main(String[] args) {
        TreeNode input = Helpers.createBinaryTree(Arrays.asList(1, 2, 2, 3, 4,4, 3));
        System.out.println(isSymmetric(input));
        Helpers.drawTree(input);
    }

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return isSymmetricHelper(root.left, root.right);
    }

    private static boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        //one side is null
        if ((left == null && right != null) || (left != null && right == null)) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
}
