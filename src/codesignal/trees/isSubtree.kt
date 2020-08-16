package codesignal.trees

import codesignal.Tree

fun isSubtree(t1: Tree<Int>?, t2: Tree<Int>?): Boolean {

    if(t2 == null){
        return true
    }

    if (t1 == null) {
        return false
    }

    if (areEqual(t1, t2)) {
        return true
    }
    return isSubtree(t1.left, t2) || isSubtree(t1.right, t2)
}


private fun areEqual(t1: Tree<Int>?, t2: Tree<Int>?): Boolean {

    if (t1 == null && t2 == null) {
        return true
    }

    if (t1?.value != t2?.value) {
        return false
    }

    return areEqual(t1?.left, t2?.left) && areEqual(t1?.right, t2?.right)
}