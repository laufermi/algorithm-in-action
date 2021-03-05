package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.Console;
import me.lauby.utils.TestHelper;
import me.lauby.utils.TestHelper.SortType;

import java.time.Duration;
import java.time.Instant;

import static me.lauby.utils.ArrayUtils.swap;

public class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[maxIdx]) < 0) {
                    maxIdx = j;
                }
            }
            swap(arr, i, maxIdx);
        }
    }

    public static <E extends Comparable<E>> void reverseSort(E[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIdx = i;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            swap(arr, i, maxIdx);
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr, SortType type) {
        for (int i = 0; i < arr.length; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (SortType.ASC == type && arr[j].compareTo(arr[maxIdx]) < 0) {
                    maxIdx = j;
                }
                if (SortType.DESC == type && arr[j].compareTo(arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            swap(arr, i, maxIdx);
        }
    }

    public static void main(String[] args) {
        int[] lens = new int[]{1000, 10000};
        for (int len : lens) {
            Integer[] arr = ArrayGenerator.getRandomArray(len, len);
            Instant startTime = Instant.now();
            SelectionSort.sort(arr, SortType.DESC);
            Instant endTime = Instant.now();
            if (!TestHelper.isSortedArray(arr, SortType.DESC)) {
                Console.log("[ERROR] Sort failed.");
                for (int i : arr) {
                    Console.log("{} ", i);
                }
            }
            Console.log("len: {}, time: {}", arr.length, Duration.between(startTime, endTime).toMillis());
        }
    }
}
