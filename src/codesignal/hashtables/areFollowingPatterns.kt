package codesignal.hashtables

fun areFollowingPatterns(strings: MutableList<String>, patterns: MutableList<String>): Boolean {

    val patternToString: MutableMap<String, String> = mutableMapOf()
    val stringToPattern: MutableMap<String, String> = mutableMapOf()

    for ((str, pattern) in strings zip patterns) {
        if (patternToString.containsKey(pattern) && patternToString[pattern] != str) {
            return false
        }

        if (stringToPattern.containsKey(str) && stringToPattern[str] != pattern) {
            return false
        }

        patternToString[pattern] = str
        stringToPattern[str] = pattern
    }

    return true
}
