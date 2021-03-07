package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.TestHelper;
import me.lauby.utils.TestHelper.SortType;

import java.util.function.BiConsumer;

import static me.lauby.utils.ArrayUtils.swap;

public class SelectionSort {
    private SelectionSort() {}

    public static <E extends Comparable<E>> BiConsumer<E[], SortType> get() {
        return SelectionSort::sort;
    }

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
            TestHelper.testSort(arr, SortType.DESC, SelectionSort.get());
        }
    }
}
