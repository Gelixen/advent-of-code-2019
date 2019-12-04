package day2;

import util.FileReader;

import java.lang.invoke.MethodHandles;
import java.util.Arrays;

public class Intcode {

    private static final int OPCODE_EXIT = 99;
    private static final int OPCODE_ADD = 1;
    private static final int OPCODE_MULTIPLY = 2;

    public static void main(String[] args) {
        int[] result = recalculateCodes(getInput(), false);

        System.out.println(result[0]);
    }

    private static String getInput() {
        String day = MethodHandles.lookup().lookupClass().getPackageName();
        return FileReader.readInput(day);
    }

    public static int[] recalculateCodes(String codesList, boolean isTestRun) {
        int[] codes = Arrays.stream(codesList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        if (!isTestRun) {
            changeCodesForRealRun(codes);
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

    private static void changeCodesForRealRun(int[] codes) {
        codes[1] = 12;
        codes[2] = 2;
    }
}
