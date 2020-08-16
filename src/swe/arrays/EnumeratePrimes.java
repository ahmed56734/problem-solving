package swe.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EnumeratePrimes {

    public static void main(String[] args) {

        System.out.println(enumeratePrimes(100));
    }

    public static List<Integer> enumeratePrimes(int n) {
        List<Integer> result = new ArrayList<>();
        boolean[] primes = new boolean[n];
        Arrays.fill(primes, true);

        for (int i = 2; i < n; i++) {
            if (primes[i]) {
                result.add(i);
                for (int j = i+i; j < n; j += i) {
                    primes[j] = false;
                }
            }
        }

        return result;
    }
}
