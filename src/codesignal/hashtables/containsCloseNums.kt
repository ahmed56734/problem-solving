package codesignal.hashtables

fun containsCloseNums(nums: MutableList<Int>, k: Int): Boolean {

    val numToIndex: MutableMap<Int, Int> = mutableMapOf()

    for ((index, value) in nums.withIndex()) {
        if (numToIndex.containsKey(value)) {
            if (index - numToIndex[value]!! <= k) {
                return true
            }
        }
        numToIndex[value] = index
    }

    return false
}
