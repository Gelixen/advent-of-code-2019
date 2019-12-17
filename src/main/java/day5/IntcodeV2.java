package day5;

import util.FileReader;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntcodeV2 {

    private static final int OPCODE_EXIT = 99;
    private static final int OPCODE_ADD = 1;
    private static final int OPCODE_MULTIPLY = 2;
    private static final int OPCODE_INPUT = 3;
    private static final int OPCODE_OUTPUT = 4;

    public static void main(String[] args) {
        List<Integer> result = recalculateCodes(getInput(), 1);
        System.out.println(result);
    }

    private static String getInput() {
        String day = MethodHandles.lookup().lookupClass().getPackageName();
        return FileReader.readInput(day);
    }

    public static List<Integer> recalculateCodes(String codesList, int input) {
        int[] program = Arrays.stream(codesList.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        int index = 0;
        Instruction instruction;
        List<Integer> output = new ArrayList<>();

        do {
            instruction = parseInstruction(program[index++]);
            int firstOperand;
            int secondOperand;

            switch (instruction.getOpcode()) {
                case OPCODE_ADD:
                    firstOperand = getValueWithMode(program, instruction.getFirstMode(), index++);
                    secondOperand = getValueWithMode(program, instruction.getSecondMode(), index++);
                    program[program[index++]] = firstOperand + secondOperand;
                    break;
                case OPCODE_MULTIPLY:
                    firstOperand = getValueWithMode(program, instruction.getFirstMode(), index++);
                    secondOperand = getValueWithMode(program, instruction.getSecondMode(), index++);
                    program[program[index++]] = firstOperand * secondOperand;
                    break;
                case OPCODE_INPUT:
                    program[program[index++]] = input;
                    break;
                case OPCODE_OUTPUT:
                    output.add(getValueWithMode(program, instruction.getFirstMode(), index++));
                    break;
            }

        } while (instruction.getOpcode() != OPCODE_EXIT);

        return output;
    }

    private static int getValueWithMode(int[] program, int mode, int value) {
        if (mode == 0) {
            return program[program[value]];
        }
        return program[value];
    }

    public static Instruction parseInstruction(int instruction) {
        int opcode = instruction % 100;
        int firstMode = instruction / 100 % 10;
        int secondMode = instruction / 1000;

        return new Instruction(opcode, firstMode, secondMode);
    }
}
