package swe.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PatternMatching {

    public static void main(String[] args) {

        String[] words = {"aba","dde","efe","yzy"};
        String pattern = "iji";
        System.out.println(findAndReplacePattern(words, pattern));
    }

    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> result = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();

        for (String word : words) {
            boolean isValid = true;
            for (int i = 0; i < word.length(); i++) {
                char wordChar = word.charAt(i);
                char patternChar = pattern.charAt(i);

                if (map.containsValue(patternChar) && map.getOrDefault(wordChar, ' ') != patternChar) {
                    isValid = false;
                    break;
                }
                if(map.containsKey(wordChar) && map.get(wordChar) != patternChar){
                    isValid = false;
                    break;
                }
                map.put(wordChar, patternChar);
            }
            if (isValid)
                result.add(word);
            map.clear();
        }

        return result;
    }
}
