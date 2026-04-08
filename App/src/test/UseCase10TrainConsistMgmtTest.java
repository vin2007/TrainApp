package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase10TrainConsistMgmtTest {

    static class Bogie {
        int capacity;
        Bogie(int c) { capacity = c; }
    }

    @Test
    void testReduce_TotalSeatCalculation() {
        List<Bogie> list = Arrays.asList(
                new Bogie(50),
                new Bogie(30)
        );

        int total = list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(80, total);
    }

    @Test
    void testReduce_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        int total = list.stream()
                .map(b -> b.capacity)
                .reduce(0, Integer::sum);

        assertEquals(0, total);
    }
}
