package day5;

public class Instruction {
    private final int opcode;
    private final int firstMode;
    private final int secondMode;

    public Instruction(int opcode, int firstMode, int secondMode) {
        this.opcode = opcode;
        this.firstMode = firstMode;
        this.secondMode = secondMode;
    }

    public int getOpcode() {
        return opcode;
    }

    public int getFirstMode() {
        return firstMode;
    }

    public int getSecondMode() {
        return secondMode;
    }
}
