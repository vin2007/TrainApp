package test;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

class UseCase12TrainConsistMgmtTest {

    static class GoodsBogie {
        String type, cargo;
        GoodsBogie(String t, String c) { type = t; cargo = c; }
    }

    @Test
    void testSafety_AllBogiesValid() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Petroleum"),
                new GoodsBogie("Box", "Coal")
        );

        boolean result = list.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(result);
    }

    @Test
    void testSafety_InvalidCargo() {
        List<GoodsBogie> list = Arrays.asList(
                new GoodsBogie("Cylindrical", "Coal")
        );

        boolean result = list.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertFalse(result);
    }

    @Test
    void testSafety_EmptyList() {
        List<GoodsBogie> list = new ArrayList<>();

        boolean result = list.stream()
                .allMatch(b -> !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum"));

        assertTrue(result);
    }
}