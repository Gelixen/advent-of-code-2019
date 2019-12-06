package day4;

import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Collections.frequency;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class Password {

    public static boolean useAlternativeCalculation;

    public static void main(String[] args) {
        long result = calculate("109165-576723");

        System.out.println(result);
    }

    public static long calculateAlternative(String range) {
        useAlternativeCalculation = true;
        return calculate(range);
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
        return useAlternativeCalculation ?
                containsRepetitiveNumbersPair1(password) :
                containsRepetitiveNumbersPair2(password);
    }

    private static boolean containsRepetitiveNumbersPair1(int password) {
        List<Integer> numbersRepetitions = Integer.toString(password)
                .chars()
                .boxed()
                .collect(Collectors.toList());

        return numbersRepetitions.stream()
                .anyMatch(repetitions -> frequency(numbersRepetitions, repetitions) == 2);
    }

    private static boolean containsRepetitiveNumbersPair2(int password) {
        Collection<Long> numbersRepetitions = Integer.toString(password)
                .chars()
                .boxed()
                .collect(groupingBy(Function.identity(), counting()))
                .values();

        return numbersRepetitions.stream().anyMatch(repetitions -> repetitions == 2);
    }
}
