package me.lauby;

import java.util.Random;

public class ArrayGenerator {

    private static final Random RANDOM = new Random();

    private ArrayGenerator() {
    }

    public static Integer[] getSortedArray(int len) {
        Integer[] arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static Integer[] getRandomArray(int len, int max) {
        Integer[] arr = new Integer[len];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = RANDOM.nextInt(max);
        }
        return arr;
    }
}
