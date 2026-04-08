package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import java.util.stream.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase9TrainConsistMgmtTest {

    static class Bogie {
        String name;
        int capacity;
        Bogie(String n, int c) { name = n; capacity = c; }
    }

    @Test
    void testGrouping_BogiesGroupedByType() {
        List<Bogie> list = Arrays.asList(
                new Bogie("Sleeper", 72),
                new Bogie("Sleeper", 70)
        );

        Map<String, List<Bogie>> map = list.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertEquals(2, map.get("Sleeper").size());
    }

    @Test
    void testGrouping_EmptyList() {
        List<Bogie> list = new ArrayList<>();

        Map<String, List<Bogie>> map = list.stream()
                .collect(Collectors.groupingBy(b -> b.name));

        assertTrue(map.isEmpty());
    }
}