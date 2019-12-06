package day4;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.frequency;

public class Password {

    public static void main(String[] args) {
        long result = calculate("109165-576723");

        System.out.println(result);
    }

    public static long calculate(String range) {
        String[] splitRange = range.split("-");

        int from = Integer.parseInt(splitRange[0]);
        int to = Integer.parseInt(splitRange[1]);

        return IntStream.rangeClosed(from, to)
                .filter(Password::orderNonDecreasing)
                .filter(Password::containsRepetitiveNumbersPair)
                .count();
    }

    private static boolean orderNonDecreasing(int password) {
        char[] numbersArray = Integer.toString(password).toCharArray();

        for (int i = 0; i < numbersArray.length - 1; i++) {
            if (numbersArray[i] > numbersArray[i + 1]) {
                return false;
            }
        }

        return true;
    }

    private static boolean containsRepetitiveNumbersPair(int password) {
        List<Integer> numbersRepetitions = Integer.toString(password)
                .chars()
                .boxed()
                .collect(Collectors.toList());

        return numbersRepetitions.stream()
                .anyMatch(repetitions -> frequency(numbersRepetitions, repetitions) == 2);
    }
}
