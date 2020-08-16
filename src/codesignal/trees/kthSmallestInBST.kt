package codesignal.trees

import codesignal.Tree


fun kthSmallestInBST(t: Tree<Int>?, k: Int): Int {
    var currentRank = 0
    var result: Int? = null

    fun inorderTraverse(node: Tree<Int>?) {
        if (node == null) {
            return
        }

        inorderTraverse(node.left)

        if (++currentRank == k) {
            result = node.value
            return
        }

        inorderTraverse(node.right)
    }

    inorderTraverse(t)

    return result!!
}