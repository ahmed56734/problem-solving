package codesignal.linkedlists

import codesignal.ListNode
import codesignal.print

fun main() {
    mergeTwoLinkedLists(ListNode.fromValues(1,4,6), ListNode.fromValues(2,3,5)).print()
}

fun mergeTwoLinkedLists(l1: ListNode<Int>?, l2: ListNode<Int>?): ListNode<Int>? {

    val dummyHead = ListNode<Int>(-123)
    var current = dummyHead
    var h1 = l1
    var h2 = l2

    while (h1 != null && h2 != null) {
        if (h1.value < h2.value) {
            current.next = ListNode(h1.value)
            h1 = h1.next
        } else {
            current.next = ListNode(h2.value)
            h2 = h2.next
        }
        current = current.next!!
    }

    if (h1 == null && h2 != null) {
        current.next = h2
    } else {
        current.next = h1
    }

    return dummyHead.next
}
