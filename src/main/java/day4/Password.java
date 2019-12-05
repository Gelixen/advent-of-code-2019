package day4;

import java.util.stream.IntStream;

public class Password {
    public static void main(String[] args) {
        long result = calculate("109165-576723");

        System.out.println(result);
    }

    public static long calculate(String range) {
        String[] splitRange = range.split("-");

        int from = Integer.parseInt(splitRange[0]);
        int to = Integer.parseInt(splitRange[1]);

        return IntStream.range(from, to + 1)
                .filter(number -> {
                    int[] numberArray = Integer.toString(number).chars().map(Character::getNumericValue).toArray();

                    boolean containsConsecutiveNumbers = false;
                    int correctOrderCount = 0;

                    for (int i = 0; i < numberArray.length - 1; i++) {
                        if (numberArray[i] == numberArray[i + 1]) {
                            containsConsecutiveNumbers = true;
                        }
                        if (numberArray[i] <= numberArray[i + 1]) {
                            correctOrderCount++;
                        }
                    }

                    return containsConsecutiveNumbers && correctOrderCount == 5;
                }).count();

    }
}
