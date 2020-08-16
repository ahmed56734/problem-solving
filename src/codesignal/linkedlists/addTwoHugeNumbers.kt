package codesignal.linkedlists

import codesignal.ListNode
import codesignal.print

fun main() {
    val a = ListNode.fromValues(9876, 5432, 1999)
    val b = ListNode.fromValues(100, 100, 100)

    addTwoHugeNumbers(a, b).print()
}

fun addTwoHugeNumbers(a: ListNode<Int>?, b: ListNode<Int>?): ListNode<Int>? {

    val num1 = a?.reverse()
    val num2 = b?.reverse()

    return sum(num1, num2)
}

private fun <T> ListNode<T>?.reverse(): ListNode<T>? {

    var previous: ListNode<T>? = null
    var current = this

    while (current != null) {
        val next = current.next
        current.next = previous
        previous = current
        current = next
    }
    return previous
}

private fun sum(a: ListNode<Int>?, b: ListNode<Int>?): ListNode<Int>? {

    val dummyHead: ListNode<Int> = ListNode(-1)
    var current = dummyHead

    tailrec fun sumHelper(h1: ListNode<Int>?, h2: ListNode<Int>?, curry: Int = 0) {
        if (h1 == null && h2 == null) {
            if (curry != 0) {
                current.next = ListNode(curry)
            }
            return
        }
        val value1 = h1?.value ?: 0
        val value2 = h2?.value ?: 0

        val sum = value1 + value2 + curry

        current.next = ListNode(sum % 10000)
        current = current.next!!

        sumHelper(h1?.next, h2?.next, sum / 10000)
    }

    sumHelper(a, b)
    return dummyHead.next?.reverse()
}
