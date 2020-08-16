package codesignal.linkedlists

import codesignal.ListNode
import codesignal.print


fun main() {
    val input = ListNode.fromValues(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
    reverseNodesInKGroups(input, 3).print()
}

fun reverseNodesInKGroups(l: ListNode<Int>?, k: Int): ListNode<Int>? {
    val dummyHead = ListNode(-1)
    dummyHead.next = l
    var current: ListNode<Int>? = dummyHead
    var nodesLeft = l.size

    while (current != null) {
        if (nodesLeft < k) {
            break
        }
        current.next = current.next.reversed(k)
        repeat(k) {
            current = current?.next
            nodesLeft--
        }
    }

    return dummyHead.next
}

private fun <T> ListNode<T>?.reversed(groupSize: Int): ListNode<T>? {
    val newTail = this
    var previous: ListNode<T>? = null
    var current = this

    for (i in 1..groupSize) {
        if (current == null)
            break

        val next = current.next
        current.next = previous
        previous = current
        current = next
    }

    newTail?.next = current

    return previous
}

private val <T> ListNode<T>?.size: Int
    get() {
        var current = this
        var count = 0
        while (current != null) {
            count++
            current = current.next
        }
        return count
    }

