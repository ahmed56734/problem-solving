package codesignal.trees

fun main() {
    println(findProfession(30, 163126329))
}

fun findProfession(level: Int, pos: Int): String {
    if (level == 1) {
        return "Engineer"
    }

    val parent = findProfession(level - 1, (pos + 1) / 2)

    return if (parent == "Engineer") {
        if (pos and 1 == 1)
            "Engineer"
        else
            "Doctor"

    } else { // parent is doctor
        if (pos and 1 == 1)
            "Doctor"
        else
            "Engineer"
    }
}
