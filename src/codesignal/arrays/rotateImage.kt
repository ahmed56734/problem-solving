package codesignal.arrays

fun rotateImage(a: MutableList<MutableList<Int>>): MutableList<MutableList<Int>> {
    flipVertically(a)
    transpose(a)

    return a
}

fun flipVertically(arr: MutableList<MutableList<Int>>) {
    for (i in 0..arr.lastIndex / 2) {
        val tmp = arr[i]
        arr[i] = arr[arr.lastIndex - i]
        arr[arr.lastIndex - i] = tmp
    }
}

fun transpose(arr: MutableList<MutableList<Int>>) {
    for (i in 0..arr.lastIndex) {
        for (j in i + 1..arr[i].lastIndex) {
            val tmp = arr[i][j]
            arr[i][j] = arr[j][i]
            arr[j][i] = tmp
        }
    }
}