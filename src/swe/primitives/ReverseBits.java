package swe.primitives;

public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(0));
    }

    static public int reverseBits(int input) {
        int output = 0;

        while (input != 0) {
            //make space for new digit = output << 1
            output = output * 2;
            //check least significant bit value -> input & 1
            if (input % 2 == 1) {
                output = output + 1;
            }
            //remove least significant bit = input >> 1
            input = input / 2;
        }

        return output;
    }
}
