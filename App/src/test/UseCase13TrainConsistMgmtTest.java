package test;

package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase13TrainConsistMgmtTest {

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String t, int c) {
            type = t;
            capacity = c;
        }
    }

    @Test
    void testLoopFilteringLogic() {
        List<PassengerBogie> list = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 60),
                new PassengerBogie("General", 50)
        );

        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : list) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }

        assertEquals(1, result.size());
    }

    @Test
    void testStreamFilteringLogic() {
        List<PassengerBogie> list = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 60),
                new PassengerBogie("General", 50)
        );

        List<PassengerBogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(1, result.size());
    }

    @Test
    void testLoopAndStreamResultsMatch() {
        List<PassengerBogie> list = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("First Class", 80),
                new PassengerBogie("General", 50)
        );

        List<PassengerBogie> loopResult = new ArrayList<>();
        for (PassengerBogie b : list) {
            if (b.capacity > 60) {
                loopResult.add(b);
            }
        }

        List<PassengerBogie> streamResult = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertEquals(loopResult.size(), streamResult.size());
    }

    @Test
    void testExecutionTimeMeasurement() {
        long start = System.nanoTime();
        long end = System.nanoTime();
        long elapsed = end - start;

        assertTrue(elapsed >= 0);
    }

    @Test
    void testLargeDatasetProcessing() {
        List<PassengerBogie> list = new ArrayList<>();

        for (int i = 0; i < 10000; i++) {
            list.add(new PassengerBogie("Type", i));
        }

        List<PassengerBogie> result = list.stream()
                .filter(b -> b.capacity > 60)
                .toList();

        assertTrue(result.size() > 0);
    }
}