package swe.strings;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LongestPalindrome {

    public static void main(String[] args) {

        System.out.println(longestPalindrome("aabbc"));
    }

    public static int longestPalindrome(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charCount.put(c, 1 + charCount.getOrDefault(c, 0));
        }

        int maxOdd = charCount.values().stream()
                .filter(value -> value % 2 == 1)
                .max(Integer::compareTo)
                .orElse(0);

        int evenSum = charCount.values().stream()
                .filter(value -> value % 2 == 0)
                .reduce(0, Integer::sum);


        return maxOdd + evenSum;
    }
}
