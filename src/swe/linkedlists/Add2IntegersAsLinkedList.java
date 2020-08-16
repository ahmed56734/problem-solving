package swe.linkedlists;

import swe.helpers.Helpers;
import swe.helpers.ListNode;

public class Add2IntegersAsLinkedList {

    public static void main(String[] args) {
        ListNode result = addTwoNumbers(Helpers.createLinkedList(2, 2, 5), Helpers.createLinkedList(5, 9, 2));
        Helpers.printLinkedList(result);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Sum = sumLinkedList(l1);

        int l2Sum = sumLinkedList(l2);

        return integerToLinkedList(l1Sum + l2Sum);
    }

    private static ListNode integerToLinkedList(int number) {
        ListNode curr = new ListNode(number % 10);
        number = number / 10;

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = curr;

        while (number != 0) {
            int lastDigit = number % 10;
            number = number / 10;
            curr.next = new ListNode(lastDigit);
            curr = curr.next;
        }
        return dummyHead.next;
    }

    private static int sumLinkedList(ListNode head) {
        int sum = 0;
        int k = 1; //digit position

        while (head != null) {
            sum += head.val * k;
            k = k * 10;
            head = head.next;
        }

        return sum;
    }
}
