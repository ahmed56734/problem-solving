package swe.trees;

import swe.helpers.Helpers;
import swe.helpers.TreeNode;

import java.awt.*;
import java.util.Arrays;

public class SumRootToLeaf {

    public static void main(String[] args) {
        TreeNode input = Helpers.createBinaryTree(Arrays.asList(1,2,2,2,5));
        System.out.println(hasPathSum(input, 5));
        Helpers.drawTree(input);
    }

    public static boolean hasPathSum(TreeNode node, int targetSum) {
        
        return hasPathSumHelper(node, targetSum, 0);
    }


    private static boolean hasPathSumHelper(TreeNode node, int targetSum, int sumSoFar) {
        if (node == null) {
            return false;
        }

        sumSoFar += node.val;

        if (sumSoFar == targetSum && node.left == null && node.right == null) {
            return true;
        } else {
            return hasPathSumHelper(node.left, targetSum, sumSoFar)
                    || hasPathSumHelper(node.right, targetSum, sumSoFar);
        }

    }
}
