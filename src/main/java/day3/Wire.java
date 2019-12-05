package day3;

import util.FileReader;

import java.awt.*;
import java.lang.invoke.MethodHandles;
import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Wire {
    public static void main(String[] args) {
        int result = calculateDistance(getInput());

        System.out.println(result);
    }

    private static String getInput() {
        String day = MethodHandles.lookup().lookupClass().getPackageName();
        return FileReader.readInput(day);
    }

    public static int calculateDistance(String wires) {
        String[] splitWires = wires.split("\n");

        String wire1 = splitWires[0];
        String wire2 = splitWires[1];

        HashMap<Point, Integer> wire1points = extractPoints(wire1);
        HashMap<Point, Integer> wire2points = extractPoints(wire2);

        wire1points.keySet().retainAll(wire2points.keySet());
        wire2points.keySet().retainAll(wire1points.keySet());

        return wire1points.entrySet().stream()
                .map(point -> point.getValue() + wire2points.get(point.getKey()))
                .min(Integer::compareTo)
                .get();
    }

    private static HashMap<Point, Integer> extractPoints(String wire) {
        HashMap<Point, Integer> points = new HashMap<>();

        AtomicInteger x = new AtomicInteger();
        AtomicInteger y = new AtomicInteger();
        AtomicInteger delay = new AtomicInteger();

        Arrays.stream(wire.split(",")).forEach(path -> {
            String direction = path.substring(0, 1);
            int distance = Integer.parseInt(path.substring(1));

            if (direction.equals("U")) {
                for (int i = 0; i < distance; i++) {
                    points.putIfAbsent(new Point(x.get(), y.incrementAndGet()), delay.incrementAndGet());
                }
            }
            if (direction.equals("D")) {
                for (int i = 0; i < distance; i++) {
                    points.putIfAbsent(new Point(x.get(), y.decrementAndGet()), delay.incrementAndGet());
                }
            }
            if (direction.equals("R")) {
                for (int i = 0; i < distance; i++) {
                    points.putIfAbsent(new Point(x.incrementAndGet(), y.get()), delay.incrementAndGet());
                }
            }
            if (direction.equals("L")) {
                for (int i = 0; i < distance; i++) {
                    points.putIfAbsent(new Point(x.decrementAndGet(), y.get()), delay.incrementAndGet());
                }
            }

        });

        return points;
    }

}
