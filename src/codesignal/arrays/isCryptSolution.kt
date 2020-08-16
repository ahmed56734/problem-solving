package codesignal.arrays

fun main() {
    println("01001".toInt())
}

@ExperimentalUnsignedTypes
fun isCryptSolution(crypt: MutableList<String>, solution: MutableList<MutableList<Char>>): Boolean {

    val solutionMap = solution.associate { it[0] to it[1] }
    val output = Array<ULong>(3) { 0UL }


    for ((i, word) in crypt.withIndex()) {
        val cipherText = word.map { solutionMap[it] }.joinToString("")

        if (cipherText.length > 1 && cipherText[0] == '0') {
            return false
        }

        output[i] = cipherText.toULong()
    }

    return output[0] + output[1] == output[2]
}
