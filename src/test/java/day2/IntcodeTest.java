package day2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static day2.Intcode.recalculateCodes;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class IntcodeTest {

    @Test
    void testCase1() {
        int[] expected = toIntArray("2,0,0,0,99");
        int[] actual = getActual("1,0,0,0,99");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCase2() {
        int[] expected = toIntArray("2,3,0,6,99");
        int[] actual = getActual("2,3,0,3,99");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCase3() {
        int[] expected = toIntArray("2,4,4,5,99,9801");
        int[] actual = getActual("2,4,4,5,99,0");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCase4() {
        int[] expected = toIntArray("30,1,1,4,2,5,6,0,99");
        int[] actual = getActual("1,1,1,4,99,5,6,0,99");
        assertArrayEquals(expected, actual);
    }

    @Test
    void testCase5() {
        int[] expected = toIntArray("3500,9,10,70,2,3,11,0,99,30,40,50");
        int[] actual = getActual("1,9,10,3,2,3,11,0,99,30,40,50");
        assertArrayEquals(expected, actual);
    }

    private int[] toIntArray(String string) {
        return Arrays.stream(string.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private int[] getActual(String codes) {
        return recalculateCodes(codes, true);
    }

}