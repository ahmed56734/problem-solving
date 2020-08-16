package codesignal.trees

import codesignal.Tree


fun hasPathWithGivenSum(t: Tree<Int>?, s: Int): Boolean {

    fun hasPathHelper(t: Tree<Int>?, sumSoFar: Int = 0): Boolean {
        if (t == null) {
            return false
        }

        val newSum = sumSoFar + t.value

        //is leaf
        if (t.left == null && t.right == null) {
            if (newSum == s) {
                return true
            }
        }

        return hasPathHelper(t.left, newSum) || hasPathHelper(t.right, newSum)
    }

    return hasPathHelper(t)
}
