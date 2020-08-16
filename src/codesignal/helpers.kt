package codesignal

data class ListNode<T>(var value: T) {
    var next: ListNode<T>? = null

    companion object {
        fun <T> fromValues(vararg values: T): ListNode<T> {
            val head = ListNode(values[0])
            var current = head
            for (i in 1..values.lastIndex) {
                current.next = ListNode(values[i])
                current = current.next!!
            }
            return head
        }
    }
}


fun <T> ListNode<T>?.print() {
    var current: ListNode<T>? = this
    while (current != null) {
        print("${current.value} -> ")
        current = current.next
    }
    print("null")
    println()
}

data class Tree<T>(var value: T) {
    var left: Tree<T>? = null;
    var right: Tree<T>? = null;
}