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

        return IntStream.rangeClosed(from, to)
                .filter(Password::orderNonDecreasing)
                .filter(Password::containsConsecutiveNumbersPair)
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

    private static boolean containsConsecutiveNumbersPair(int password) {
        char[] numbersArray = Integer.toString(password).toCharArray();

        for (int i = 0; i < numbersArray.length - 1; i++) {
            if (numbersArray[i] == numbersArray[i + 1]) {
                return true;
            }
        }

        return false;
    }
}
