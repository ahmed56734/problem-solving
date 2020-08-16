package swe.trees;

import swe.helpers.Helpers;
import swe.helpers.TreeNode;

public class BSTFromSortedArray {

    public static void main(String[] args) {

        int[] input = {-3, 1, 2, 3, 5, 6, 8, 11};
        TreeNode output = sortedArrayToBST(input);
        Helpers.drawTree(output);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        int rootIndex = nums.length / 2;
        TreeNode root = new TreeNode(nums[rootIndex]);
        root.left = nodeCreator(nums, 0, rootIndex - 1);
        root.right = nodeCreator(nums, rootIndex + 1, nums.length - 1);

        return root;
    }

    private static TreeNode nodeCreator(int[] nums, int min, int max) {
        if (min > max) {
            return null;
        }
        int index = (min + max) / 2;
        TreeNode node = new TreeNode(nums[index]);
        node.left = nodeCreator(nums, min, index - 1);
        node.right = nodeCreator(nums, index + 1, max);
        return node;
    }


}
