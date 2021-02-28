package me.lauby;

public class TestHelper {

    private TestHelper() {}

    public static <E extends Comparable<E>> boolean isSortedArray(E[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i].compareTo(arr[i + 1]) > 0) {
                return false;
            }
        }
        return true;
    }

}
