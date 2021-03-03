package me.lauby;

import me.lauby.utils.ArrayGenerator;
import me.lauby.utils.Console;

import java.time.Duration;
import java.time.Instant;

public class LinerSearch {

    private LinerSearch() {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        int[] times = new int[]{10000000, 10000000, 10000000};
        for (int maxLength : times) {
            Integer[] scores = ArrayGenerator.getSortedArray(maxLength);
            Instant startTime = Instant.now();
            search(scores, maxLength - 1);
            Instant endTime = Instant.now();
            long millis = Duration.between(startTime, endTime).toMillis();
            Console.log("len: {}, time: {}", maxLength, millis);
        }
    }

    private static <E> int search(E[] scores, E target) {
        for (int i = 0; i < scores.length; i++) {
            if (scores[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }
}
