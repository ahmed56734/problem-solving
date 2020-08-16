package swe.linkedlists;

import swe.helpers.Helpers;
import swe.helpers.ListNode;

public class RightShiftLinkedList {
    public static void main(String[] args) {
        ListNode result = rotateRight(Helpers.createLinkedList(4,1,6,7), 4);
        Helpers.printLinkedList(result);
    }

    public static ListNode rotateRight(ListNode head, int k) {
        ListNode newHead;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;

        //find linked list size
        int size = getSize(head);
        k = k % size;

        if(k == 0){
            return head;
        }

        //find kth element from the last as new head
        ListNode leftPointer = fakeHead;
        ListNode rightPointer = fakeHead;
        // move right k times;
        for (int i = 0; i < k; i++)
            rightPointer = rightPointer.next;

        while (rightPointer.next != null) {
            rightPointer = rightPointer.next;
            leftPointer = leftPointer.next;
        }
        //right pointer is now at the last node
        //left pointer is before new head
        newHead = leftPointer.next;
        rightPointer.next = head;
        leftPointer.next = null;

        return newHead;
    }

    private static int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }
}
