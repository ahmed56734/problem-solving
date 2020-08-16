package playground;

public class day3 {

    public static void main(String[] args) {
        System.out.println(reverseString("abc"));
        System.out.println(reverseDecimal(1234));
        System.out.println(reverseBinary(9090));
    }

    public static String reverseString(String input) {
        String result = "";

        while (!input.isEmpty()) {
            //get last char
            char lastChar = input.charAt(input.length() - 1);
            //add last char
            result = result + lastChar;
            //remove last char
            input = input.substring(0, input.length() - 1);
        }

        return result;
    }

    public static int reverseDecimal(int input) {
        int result = 0;

        while (input != 0) {
            //get last digit
            int lastDigit = input % 10;
            //add last digit
            result = (result * 10) + lastDigit;
            //remove last char
            input = input / 10;
        }
        return result;
    }

    public static int reverseBinary(int input) {
        int result = 0;

        while (input != 0) {
            //get last digit
            int lastDigit = input & 1;
            //add last digit
            result = (result << 1) + lastDigit;
            //remove last char
            input = input >> 1;
        }
        return result;
    }
}
