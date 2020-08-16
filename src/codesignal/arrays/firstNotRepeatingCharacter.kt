package codesignal.arrays

fun main() {
    val result = firstNotRepeatingCharacter("abacabad")
    println(result)
}

fun firstNotRepeatingCharacter(s: String): Char {
    val charCount = mutableMapOf<Char, Int>()

    for (c in s)
        charCount[c] = charCount.getOrDefault(c, 0) + 1

    for (c in s) {
        if (charCount[c] == 1) {
            return c
        }
    }
    return '_'
}