package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.Console;
import me.lauby.utils.TestHelper;

import java.time.Duration;
import java.time.Instant;

import static me.lauby.utils.ArrayUtils.swap;

public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr, TestHelper.SortType sortType) {
        if (TestHelper.SortType.DESC == sortType) {
            for (int i = arr.length - 1; i >= 0; i--) {
                for (int j = i; j < arr.length - 1 && arr[j].compareTo(arr[j + 1]) <= 0; j++) {
                    swap(arr, j, j + 1);
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                for (int j = i; j >= 1 && arr[j].compareTo(arr[j - 1]) <= 0; j--) {
                    swap(arr, j, j - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] lens = new int[]{1000, 10000};
        for (int len : lens) {
            Integer[] arr = ArrayGenerator.getRandomArray(len, len);
            Instant startTime = Instant.now();
            InsertionSort.sort(arr, TestHelper.SortType.ASC);
            Instant endTime = Instant.now();
            if (!TestHelper.isSortedArray(arr, TestHelper.SortType.ASC)) {
                Console.log("[ERROR] Sort failed.");
                for (int i : arr) {
                    Console.log("{} ", i);
                }
            }
            Console.log("len: {}, time: {}", arr.length, Duration.between(startTime, endTime).toMillis());
        }
    }
}
