package day1;

import util.FileReader;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

public class RocketFuel {

    public static void main(String[] args) {
        int result = Arrays.stream(getInput().split("\n"))
                .mapToInt(Integer::parseInt)
                .map(RocketFuel::calculateFuel)
                .sum();

        System.out.println(result);
    }

    private static String getInput() {
        String day = MethodHandles.lookup().lookupClass().getPackageName();
        return FileReader.readInput(day);
    }

    public static int calculateFuel(int mass) {
        return mass / 3 - 2;
    }
}
