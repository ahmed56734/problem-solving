package codesignal.arrays

import kotlin.math.abs

fun main() {

}

fun firstDuplicate(a: MutableList<Int>): Int {
    for (item in a) {
        val currentValue = abs(item)

        if (a[currentValue - 1] < 0) {
            return currentValue
        } else {
            a[currentValue - 1] = a[currentValue - 1] * -1
        }
    }

    return -1
}