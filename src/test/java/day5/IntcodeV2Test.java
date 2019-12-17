package day5;

import org.junit.jupiter.api.Test;

import static java.util.Collections.singletonList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class IntcodeV2Test {

    @Test
    void parseInstruction_addOpcodeWithPositionModes() {
        Instruction instruction = IntcodeV2.parseInstruction(1);
        assertEquals(1, instruction.getOpcode());
        assertEquals(0, instruction.getFirstMode());
        assertEquals(0, instruction.getSecondMode());
    }

    @Test
    void parseInstruction_multiplyOpcodeWithImmediateModes() {
        Instruction instruction = IntcodeV2.parseInstruction(1102);
        assertEquals(2, instruction.getOpcode());
        assertEquals(1, instruction.getFirstMode());
        assertEquals(1, instruction.getSecondMode());
    }

    @Test
    void parseInstruction_multiplyOpcodeWithMixedModes() {
        Instruction instruction = IntcodeV2.parseInstruction(1002);
        assertEquals(2, instruction.getOpcode());
        assertEquals(0, instruction.getFirstMode());
        assertEquals(1, instruction.getSecondMode());
    }

    @Test
    void recalculateCodes_returnOutputWith99() {
        assertEquals(singletonList(99), IntcodeV2.recalculateCodes("1002,6,3,6,4,6,33", 1));
    }

    @Test
    void recalculateCodes_returnOutputWith100() {
        assertEquals(singletonList(100), IntcodeV2.recalculateCodes("1101,100,-1,6,4,1,0", 1));
    }

    @Test
    void recalculateCodes_inputAndOutput_changeFirstCodeAndReturnIt() {
        assertEquals(singletonList(1), IntcodeV2.recalculateCodes("3,0,4,0,99", 1));
    }
}