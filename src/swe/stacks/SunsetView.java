package swe.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SunsetView {

    public static void main(String[] args) {
        int[] input = {7, 4, 8, 2, 9};
        System.out.println(getBuildingsWithAView(input));
    }


    public static List<Integer> getBuildingsWithAView(int[] buildings) {
        List<Integer> result = new ArrayList<>();
        int largest = 0;

        //add first building
        if(buildings.length != 0){
            result.add(0);
            largest = buildings[0];
        }

        for (int i = 1; i < buildings.length; i++) {
            int height = buildings[i];
            if (height > largest) {
                result.add(i);
                largest = height;
            }
        }

        return result;
    }
}
