package me.lauby.utils;

public class TestHelper {

    private TestHelper() {}

    public static <E extends Comparable<E>> boolean isSortedArray(E[] arr, SortType sortType) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (SortType.ASC == sortType && arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

    public enum SortType {
        ASC,
        DESC
    }

}
