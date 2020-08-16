package codesignal.trees

import codesignal.Tree

fun isTreeSymmetric(t: Tree<Int>?): Boolean {

    fun isTreeSymmetricHelper(left: Tree<Int>?, right: Tree<Int>?): Boolean {
        if (left == null && right == null) {
            return true
        }


        if (left?.value != right?.value) {
            return false
        }

        return isTreeSymmetricHelper(left?.left, right?.right) && isTreeSymmetricHelper(left?.right, right?.left)
    }

    return if (t == null) {
        true
    } else {
        isTreeSymmetricHelper(t.left, t.right)
    }
}
