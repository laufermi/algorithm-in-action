package me.lauby.utils;

public class ArrayUtils {
    private ArrayUtils() {
    }

    public static <E> void swap(E[] arr, int from, int to) {
        E tmp = arr[from];
        arr[from] = arr[to];
        arr[to] = tmp;
    }
}
