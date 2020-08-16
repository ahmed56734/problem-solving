package swe.strings;

public class ValidPalindrome {

    public static void main(String[] args) {

        System.out.println(validPalindrome("a,b,c,ba"));

    }



    public static boolean validPalindrome(String s) {
        if (s.isEmpty() || s.length() == 1) {
            return true;
        }

        char leftChar = Character.toLowerCase(s.charAt(0));
        char rightChar = Character.toLowerCase(s.charAt(s.length() - 1));

        if (!Character.isAlphabetic(leftChar)) {
            return validPalindrome(s.substring(1));
        }

        if (!Character.isAlphabetic(rightChar)) {
            return validPalindrome(s.substring(0, s.length() - 1));
        }

        if (rightChar != leftChar) {
            return false;
        }

        return validPalindrome(s.substring(1, s.length() - 1));
    }
}
