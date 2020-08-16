package playground;

public class day1 {

    public static void main(String[] args) {

    }

    public static boolean isPalindrome(String input) {
        while (!input.isEmpty()) {
            char left = input.charAt(0);
            char right = input.charAt(input.length() - 1);

            if (right != left) {
                return false;
            }
            input = input.substring(1, input.length() - 1);
        }

        return true; //O(n)
    }

    public static boolean isPalindrome2(String input) {
        int leftIndex = 0;
        int rightIndex = input.length() - 1;


        while (leftIndex < rightIndex) {
            if (input.charAt(leftIndex) != input.charAt(rightIndex))
                return false;

            leftIndex++;
            rightIndex--;
        }

        return true; //O(n)
    }

    public static boolean isPalindrome3(String input) {
        if (input.isEmpty()) {
            return true;
        }

        char left = input.charAt(0);
        char right = input.charAt(input.length() - 1);

        if (left != right) {
            return false;
        }

        return isPalindrome3(input.substring(1, input.length() - 1));
    }


}
