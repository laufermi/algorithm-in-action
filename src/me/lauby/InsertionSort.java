package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.Console;
import me.lauby.utils.TestHelper;
import me.lauby.utils.TestHelper.SortType;

import java.time.Duration;
import java.time.Instant;

import static me.lauby.utils.ArrayUtils.swap;

public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr, SortType sortType) {
        if (SortType.DESC == sortType) {
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

    public static <E extends Comparable<E>> void sortFast(E[] arr, SortType sortType) {
        if (SortType.DESC == sortType) {
            for (int i = arr.length - 1; i >= 0; i--) {
                E target = arr[i];
                for (int j = i; j + 1 < arr.length; j++) {
                    if (target.compareTo(arr[j + 1]) < 0) {
                        arr[j] = arr[j + 1];
                    } else {
                        arr[j + 1] = target;
                        break;
                    }
                }
            }
        } else {
            for (int i = 0; i < arr.length; i++) {
                E target = arr[i];
                for (int j = i; j - 1 >= 0; j--) {
                    if (target.compareTo(arr[j - 1]) < 0) {
                        arr[j] = arr[j - 1];
                    } else {
                        arr[j] = target;
                        break;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] lens = new int[]{100000, 100000};
        for (int len : lens) {
            Integer[] arr = ArrayGenerator.getRandomArray(len, len);
            Instant startTime = Instant.now();
            InsertionSort.sortFast(arr, SortType.DESC);
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
