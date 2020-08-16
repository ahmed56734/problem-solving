package codesignal.linkedlists

import codesignal.ListNode
import codesignal.print

fun main() {
    val input = ListNode.fromValues(1000, 1000)
    input.print()
    removeKFromList(input, 1000).print()

}

fun removeKFromList(l: ListNode<Int>?, k: Int): ListNode<Int>? {
    val dummyHead = ListNode(0)
    var current: ListNode<Int>? = l
    dummyHead.next = current
    var previous: ListNode<Int>? = dummyHead

    while (current != null) {
        if (current.value == k) {
            previous?.next = current.next
        } else {
            previous = current
        }
        current = current.next
    }

    return dummyHead.next
}
