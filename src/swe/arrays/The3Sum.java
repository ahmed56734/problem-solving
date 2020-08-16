package swe.arrays;

import java.util.*;

public class The3Sum {

    public static void main(String[] args) {
        int[] arr = {-3, -1, 1, 0, 2, 10, -2, 8};
        System.out.println(threeSum(arr));
    }

    public static List<List<Integer>> threeSum(int[] A) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(A);
        int targetSum = 0;

        for (int i = 0; i < A.length - 3; i++) {
            int first = A[i];

            int j = i + 1; //left pointer
            int k = A.length - 1; //right pointer

            while (j != k) {
                int second = A[j];
                int third = A[k];
                int sum = first + second + third;
                if (sum == targetSum) {
                    result.add(Arrays.asList(first, second, third));
                    j++; //move any pointer
                } else if (sum > targetSum) {
                    k--; //move right pointer to the left
                } else {
                    j++; //move left pointer to the right
                }

            }
        }

        return new ArrayList<>(result);
    }
}
