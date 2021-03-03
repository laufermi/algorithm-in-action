package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.Console;
import me.lauby.utils.TestHelper;

import java.time.Duration;
import java.time.Instant;

public class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[i]) < 0) {
                    swap(arr, i, j);
                }
            }
        }
    }

    private static <E> void swap(E[] arr, int a, int b) {
        E tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] lens = new int[]{1000, 10000};
        for (int len : lens) {
            Integer[] arr = ArrayGenerator.getRandomArray(len, len);
            Instant startTime = Instant.now();
            SelectionSort.sort(arr);
            Instant endTime = Instant.now();
            if (!TestHelper.isSortedArray(arr)) {
                Console.log("[ERROR] Sort failed.");
                for (int i : arr) {
                    Console.log("{} ", i);
                }
            }
            Console.log("len: {}, time: {}", arr.length, Duration.between(startTime, endTime).toMillis());
        }
    }
}
