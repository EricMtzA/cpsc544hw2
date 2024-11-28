package com.example.visualsort;

import java.util.ArrayList;
import java.util.Arrays;

public class VisualSort {

    private static String userInput;
    static ArrayList<int[]> masterList;

    public static int[] sort(String input) {
        userInput = input;
        // input String = "2 1"
        if(input == null) {
            throw new NullPointerException("Input cannot be null");
        }

        String[] parts = input.split(" ");

        if (parts.length < 3) {
            throw new IllegalArgumentException("Input must contain at least 3 numbers");
        }
        if (parts.length > 8) {
            throw new IllegalArgumentException("Input must contain 8 or fewer numbers");
        }

        int[] initArray = new int[parts.length];
        //int[] sortedArray = new int[]{};
        ArrayList<int[]> masterList = new ArrayList<>();

        for(int i = 0; i < parts.length; i++) {
            // "1 2 a 4"
            if (!parts[i].matches("\\d+")) {
                throw new IllegalArgumentException("Input must contain only single-digit numbers");
            }
            // "11 2 1 3"
            if (parts[i].length() > 1) {
                throw new IllegalArgumentException("Numbers must be single digit");
            }
            initArray[i] = Integer.parseInt(parts[i]);
        }
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
            if(i == 1) {
                masterList.add(Arrays.copyOf(initArray, initArray.length));
            }

            while (j >= 0 && initArray[j] > key){
                initArray[j + 1] = initArray[j];
                j--;
            }
            initArray[j + 1] = key;
            masterList.add(Arrays.copyOf(initArray, initArray.length));
        }
        // Printing the contents of masterList
        for (int i = 0; i < masterList.size(); i++) {
            int[] array = masterList.get(i);
        }

        setMasterList(masterList);
        return initArray;
    }

    private static void setMasterList(ArrayList<int[]> list) {
        masterList = new ArrayList<>(list);
    }

    public static String getSortResults() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Input array: %s\n", userInput));
        sb.append("Insertion Sort\n(Intermediate Steps)\n\n");

        for (int[] m : masterList) {
            sb.append(Arrays.toString(m).replaceAll("[\\[,\\]]", ""));
            sb.append("\n");
        }

        return sb.toString();
    }
}
