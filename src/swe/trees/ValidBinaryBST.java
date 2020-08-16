package swe.trees;

import swe.helpers.Helpers;
import swe.helpers.TreeNode;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public class ValidBinaryBST {
    public static void main(String[] args) {
        TreeNode input = Helpers.createBinaryTree(Arrays.asList(-2147483648, null, 2147483647));
        System.out.println(isValidBST(input));
        Helpers.drawTree(input);
    }


    public static boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, null, null);
    }

    private static boolean isValidBSTHelper(TreeNode node, Integer lowerBound, Integer upperBound) {
        if (node == null) {
            return true;
        }

        if (upperBound != null && node.val >= upperBound) {
            return false;
        }

        if (lowerBound != null && node.val <= lowerBound) {
            return false;
        }

        return isValidBSTHelper(node.left, lowerBound, node.val) && isValidBSTHelper(node.right, node.val, upperBound);
    }
}
