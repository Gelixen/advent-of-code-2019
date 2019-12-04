package day2;

import util.FileReader;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

public class Intcode {

    private static final int OPCODE_EXIT = 99;
    private static final int OPCODE_ADD = 1;
    private static final int OPCODE_MULTIPLY = 2;

    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 99;

    public static void main(String[] args) {
        for (int noun = LOWER_LIMIT; noun < UPPER_LIMIT; noun++) {
            for (int verb = LOWER_LIMIT; verb < UPPER_LIMIT; verb++) {
                int[] result = recalculateCodes(getInput(), false, noun, verb);

                if (result[0] == 19690720) {
                    System.out.println(100 * noun + verb);
                    return;
                }
            }
        }
    }

    private static String getInput() {
        String day = MethodHandles.lookup().lookupClass().getPackageName();
        return FileReader.readInput(day);
    }

    public static int[] recalculateCodes(String codesList, boolean isTestRun) {
        return recalculateCodes(codesList, isTestRun, 0, 0);
    }

    public static int[] recalculateCodes(String codesList, boolean isTestRun, int noun, int verb) {
        int[] codes = Arrays.stream(codesList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (!isTestRun) {
            changeCodesForRealRun(codes, noun, verb);
        }

        int index = 0;
        int opcode = codes[index];
        int operand1;
        int operand2;
        int saveIndex;

        do {
            operand1 = codes[++index];
            operand2 = codes[++index];
            saveIndex = codes[++index];

            if (opcode == OPCODE_ADD) {
                codes[saveIndex] = codes[operand1] + codes[operand2];
            }

            if (opcode == OPCODE_MULTIPLY) {
                codes[saveIndex] = codes[operand1] * codes[operand2];
            }

            opcode = codes[++index];
        } while (opcode != OPCODE_EXIT);

        return codes;
    }

    private static void changeCodesForRealRun(int[] codes, int noun, int verb) {
        codes[1] = noun;
        codes[2] = verb;
    }
}
