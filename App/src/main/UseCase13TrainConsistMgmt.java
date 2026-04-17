package main;

import java.util.*;
import java.util.stream.Collectors;

public class UseCase13TrainConsistMgmt {

    static class PassengerBogie {
        String type;
        int capacity;

        PassengerBogie(String type, int capacity) {
            this.type = type;
            this.capacity = capacity;
        }
    }

    public static List<PassengerBogie> filterWithLoop(List<PassengerBogie> bogies) {
        List<PassengerBogie> result = new ArrayList<>();
        for (PassengerBogie b : bogies) {
            if (b.capacity > 60) {
                result.add(b);
            }
        }
        return result;
    }

    public static List<PassengerBogie> filterWithStream(List<PassengerBogie> bogies) {
        return bogies.stream()
                .filter(b -> b.capacity > 60)
                .collect(Collectors.toList());
    }

    public static long measureExecutionTime(Runnable task) {
        long start = System.nanoTime();
        task.run();
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        List<PassengerBogie> bogies = Arrays.asList(
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 60),
                new PassengerBogie("First Class", 80),
                new PassengerBogie("General", 50)
        );

        long loopTime = measureExecutionTime(() -> filterWithLoop(bogies));
        long streamTime = measureExecutionTime(() -> filterWithStream(bogies));

        System.out.println(loopTime);
        System.out.println(streamTime);
    }
}