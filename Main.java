package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[] myArray = {3, 1, 4, 1, 5, 9, 2, 6};
        RunningMedian runMed = new RunningMedian();
        double[] medians = runMed.getMedians(myArray);
        /*for (double num : medians){
            System.out.println(num);
        }*/
        System.out.println(Arrays.toString(medians));
    }
}
