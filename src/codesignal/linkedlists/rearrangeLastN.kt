package codesignal.linkedlists

import codesignal.ListNode


fun rearrangeLastN(l: ListNode<Int>?, n: Int): ListNode<Int>? {

    if (l == null || n == 0) {
        return l
    }

    val rotations = n % l.length

    if (rotations == 0) {
        return l
    }

    var slow = l
    var fast = l

    repeat(n) {
        fast = fast?.next
    }

    while (fast?.next != null) {
        fast = fast?.next
        slow = slow?.next
    }

    //fast pointing to the original tail
    //slow is pointing to the new tail
    //slow.next is the new head

    val head = slow?.next
    slow?.next = null
    fast?.next = l

    return head
}

private val <T> ListNode<T>?.length: Int
    get() {
        var length = 0
        var curr = this
        while (curr != null) {
            length++
            curr = curr.next
        }
        return length
    }