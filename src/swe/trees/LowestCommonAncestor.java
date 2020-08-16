package swe.trees;

import swe.helpers.Helpers;
import swe.helpers.TreeNode;

import java.util.Arrays;

public class LowestCommonAncestor {


    public static void main(String[] args) {
        TreeNode input = Helpers.createBinaryTree(Arrays.asList(50, 25, 100, 1, 27,80, 101));
        System.out.println(lowestCommonAncestor(input, 1, 27));
        Helpers.drawTree(input);

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, int x, int y) {
        if (root.left == null || root.right == null) {
            return root;
        }

        if (x < root.val && y < root.val) {
            return lowestCommonAncestor(root.left, x, y);
        } else if (y > root.val && x > root.val) {
            return lowestCommonAncestor(root.right, x, y);
        } else {
            return root;
        }

    }

}
