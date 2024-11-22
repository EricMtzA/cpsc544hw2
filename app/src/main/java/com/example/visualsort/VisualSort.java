package com.example.visualsort;

import java.util.ArrayList;
import java.util.Arrays;

public class VisualSort {

    public int[] sort(String input) {
        int[] initArray = new int[input.length()];
        int[] sortedArray = new int[]{};
        ArrayList<int[]> masterList = new ArrayList<>();

        for(int i = 0; i < input.length(); i++) {
            initArray[i] = input.charAt(i) - '0';
        }
        masterList.add(initArray);
        // 0 1 2 3
        // 4 1 2 3 -> i=1 so j= 0 ~> i:1 & j:4
        // if array[j] > array[i]=key swap and save new array into array of arrays
        // 0 1 2 3
        // 1 4 2 3 -> i=2 so j=1 ~> i:2 & j:4
        // if array[j] > array[i]=key swap and save new array into array of arrays
        // 0 1 2 3
        // 1 2 4 3 -> i=3 so j=2 ~> i:3 & j:4
        // if array[j] > array[i]=key swap and save new array into array of arrays
        // 0 1 2 3
        // 1 2 3 4 -> i=3 so j=2 ~> i:3 & j:4
        // FINAL ARRAY?
        for(int i = 1; i < initArray.length; i++){
            int j = i - 1;
            int key = initArray[i];

            while (j >= 0 && initArray[j] > key){
                initArray[j + 1] = initArray[j];
                j--;
            }
            initArray[j + 1] = key;
            masterList.add(initArray);
        }

        return initArray;
    }
}
