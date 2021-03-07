package me.lauby.utils;

import java.time.Duration;
import java.time.Instant;
import java.util.function.BiConsumer;

public class TestHelper {

    private TestHelper() {}

    public static <E extends Comparable<E>> void testSort(E[] arr, SortType sortType, BiConsumer<E[], SortType> sorting) {
        Instant startTime = Instant.now();
        sorting.accept(arr, sortType);
        Instant endTime = Instant.now();
        if (!TestHelper.isSortedArray(arr, SortType.DESC)) {
            Console.log("[ERROR] Sort failed.");
            for (E i : arr) {
                Console.log("{} ", i);
            }
        }
        Console.log("len: {}, time: {}", arr.length, Duration.between(startTime, endTime).toMillis());
    }

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
