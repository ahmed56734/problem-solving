package swe.linkedlists;

import swe.helpers.Helpers;
import swe.helpers.ListNode;

public class RemoveKthToLastElement {
    public static void main(String[] args) {

        ListNode result = removeKthToLast(Helpers.createLinkedList(2,3,5), 3);
        Helpers.printLinkedList(result);

    }

    public static ListNode removeKthToLast(ListNode head, int k) {
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        ListNode left = fakeHead;
        ListNode right = fakeHead;

        //move right k+1 times
        for (int i = 0; i < k+1; i++)
            right = right.next;

        while (right != null) {
            left = left.next;
            right = right.next;
        }

        left.next = left.next.next;

        return fakeHead.next;
    }
}
