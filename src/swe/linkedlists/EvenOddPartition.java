package swe.linkedlists;

import swe.helpers.Helpers;
import swe.helpers.Helpers.*;
import swe.helpers.ListNode;

public class EvenOddPartition {

    public static void main(String[] args) {
        ListNode result = oddEvenList(Helpers.createLinkedList(5,1,3,7,3));
        Helpers.printLinkedList(result);
    }

    public static ListNode oddEvenList(ListNode head) {

        ListNode curr = head;

        ListNode oddHead = new ListNode(-1);
        ListNode oddCurr = oddHead;

        ListNode evenHead = new ListNode(-1);
        ListNode evenCurr = evenHead;

        int currentIndex = 0;

        while (curr != null) {
            if ((currentIndex & 1) == 0) {
                evenCurr.next = curr;
                evenCurr = evenCurr.next;
            } else {
                oddCurr.next = curr;
                oddCurr = oddCurr.next;
            }
            curr = curr.next;
            currentIndex++;
        }

        evenCurr.next = null;
        oddCurr.next = null;

        evenCurr.next = oddHead.next;

        return evenHead.next;
    }


}
