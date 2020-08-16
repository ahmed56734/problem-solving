package playground


fun main() {
    val head = ListNode.fromValues(1, 2,  2, 1)
    head.print()
    println(head.middle?.value)
//    head.reversed().print()

    println("isPalindrome ${head.isPalindrome()}")
}

private fun <T> ListNode<T>?.isPalindrome(): Boolean? {
    val head1 = this
    val middle = this.middle
    var head2 = middle?.next
    middle?.next = null

    head2 = head2.reversed()

    return head1 isEqual head2
}

private infix fun <T> ListNode<T>?.isEqual(head2: ListNode<T>?): Boolean? {
    var curr1 = this
    var curr2 = head2

    while (curr1 != null && curr2 != null) {
        if (curr1.value != curr2.value) {
            return false
        }
        curr1 = curr1.next
        curr2 = curr2.next
    }
    return true
}

private fun <T> ListNode<T>?.reversed(): ListNode<T>? {
    var previous: ListNode<T>? = null
    var curr: ListNode<T>? = this

    while (curr != null) {
        val next = curr.next
        curr.next = previous
        previous = curr
        curr = next
    }

    return previous
}

private fun <T> ListNode<T>?.print() {
    var curr = this
    while (curr != null) {
        print("${curr.value} -> ")
        curr = curr.next
    }
    print("null")
    println()
}

private val <T> ListNode<T>?.middle: ListNode<T>?
    get() {
        var fast = this
        var slow = this

        while (fast?.next != null) {
            fast = fast.next
            if (fast?.next != null) {
                fast = fast?.next
                slow = slow?.next
            }
        }
        return slow
    }


data class ListNode<T>(var value: T) {
    var next: ListNode<T>? = null

    companion object {
        fun <T> fromValues(vararg values: T): ListNode<T>? {
            val dummy = ListNode(values[0])
            var curr: ListNode<T>? = dummy

            for (value in values) {
                curr?.next = ListNode(value)
                curr = curr?.next
            }

            return dummy.next
        }
    }
}