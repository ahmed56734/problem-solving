package swe.primitives;

//https://backtobackswe.com/platform/content/check-if-a-number-is-a-palindrome/code

public class PalindromeNumber {


    public static void main(String[] args) {

        System.out.println(isPalindrome(1));

    }


    // how get digit number
    // how get left digit
    // how remove left digit

    // how get right digit
    // how remove right digit


    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x == 0) {
            return true;
        }

        int numberOfDigits = (int) Math.floor(Math.log10(x)) + 1;
        if (numberOfDigits == 1) {
            return true;
        }
        int mask = (int) Math.pow(10, numberOfDigits - 1);
        int rightDigit = x % 10;
        int leftDigit = x / mask;

        if (rightDigit != leftDigit) {
            return false;
        }

        int newX = x % mask; //remove left digit
        newX = newX / 10; //remove right digit

        return isPalindrome(newX);
    }
}
