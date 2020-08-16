package codesignal.linkedlists

import codesignal.ListNode
import codesignal.print

fun main() {
    val node = ListNode.fromValues(1)
    println(isListPalindrome(node))
}

fun isListPalindrome(l: ListNode<Int>?): Boolean {
    if (l?.next == null) //has zero or one item
        return true

    var slow = l!!
    var fast = l!!

    while (fast.next != null) {
        fast = fast.next!!
        if (fast.next != null) {
            fast = fast.next!!
            slow = slow.next!!
        }
    }

    var head1 = slow.next
    slow.next = null
    head1 = head1?.reverse()
    var head2 = l

    while (head1 != null && head2 != null) {
        if (head1.value != head2.value) {
            return false
        }
        head1 = head1.next
        head2 = head2.next
    }

    return true
}

private fun <T> ListNode<T>?.reverse(): ListNode<T>? {
    if (this == null) {
        return null
    }

    var previous: ListNode<T>? = null
    var current = this
    var next: ListNode<T>?

    while (current != null) {
        next = current.next
        current.next = previous
        previous = current
        current = next
    }

    return previous
}
