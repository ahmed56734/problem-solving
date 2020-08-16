package swe.helpers;

import java.util.List;

public class Helpers {


    public static void printLinkedList(ListNode node) {
        if (node == null) {
            System.out.print("null");
            System.out.println();
            return;
        }
        System.out.print(node.val + " -> ");
        printLinkedList(node.next);
    }

    public static ListNode createLinkedList(int... values) {
        ListNode head = new ListNode(-1);
        ListNode curr = head;

        for (int value : values) {
            curr.next = new ListNode(value);
            curr = curr.next;
        }
        return head.next;
    }

    public static void drawTree(TreeNode root) {
        BTreePrinter.printNode(root);
    }

    public static TreeNode createBinaryTree(List<Integer> elements) {
        TreeNode root = new TreeNode(elements.get(0));
        root.left = createBinaryTreeHelper(elements, 1);
        root.right = createBinaryTreeHelper(elements, 2);
        return root;
    }

    private static TreeNode createBinaryTreeHelper(List<Integer> elements, int index) {
        TreeNode node = null;
        if (index < elements.size()) {
            Integer element = elements.get(index);
            if (element == null) {
                return null;
            }
            node = new TreeNode(elements.get(index));

            node.left = createBinaryTreeHelper(elements,
                    2 * index + 1);

            node.right = createBinaryTreeHelper(elements,
                    2 * index + 2);
        }
        return node;
    }
}

