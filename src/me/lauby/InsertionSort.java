package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.TestHelper;
import me.lauby.utils.TestHelper.SortType;

import java.util.function.BiConsumer;

import static me.lauby.utils.ArrayUtils.swap;

public class InsertionSort {
    private InsertionSort() {
    }

    public static <E extends Comparable<E>> BiConsumer<E[], SortType> get() {
        return InsertionSort::sortFast;
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
        int[] lens = new int[]{1000, 1000};
        for (int len : lens) {
            Integer[] arr = ArrayGenerator.getRandomArray(len, len);
            TestHelper.testSort(arr, SortType.ASC, InsertionSort.get());
        }
    }
}
