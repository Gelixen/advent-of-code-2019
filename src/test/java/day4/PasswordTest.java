package day4;

import org.junit.jupiter.api.Test;

import static day4.Password.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordTest {

    @Test
    void testCase1() {
        assertEquals(0, calculate("111111-111111"));
    }

    @Test
    void testCase2() {
        assertEquals(0, calculate("111111-111119"));
    }

    @Test
    void testCase3() {
        assertEquals(5, calculate("123455-123499"));
    }

    @Test
    void testCase4() {
        assertEquals(1, calculate("112233-112233"));
    }

    @Test
    void testCase5() {
        assertEquals(0, calculate("111222-111222"));
    }

    @Test
    void testCase6() {
        assertEquals(0, calculate("122223-122223"));
    }

    @Test
    void testCase7() {
        assertEquals(1, calculate("122233-122233"));
    }

    @Test
    void testCase8() {
        assertEquals(0, calculate("122222-122222"));
    }

    @Test
    void testCase9() {
        assertEquals(0, calculate("122234-122234"));
    }

    @Test
    void testCase10() {
        assertEquals(0, calculate("123444-123444"));
    }

    @Test
    void testCase11() {
        assertEquals(1, calculate("111122-111122"));
    }

    @Test
    void testCase12() {
        assertEquals(1, calculate("122233-122233"));
    }

}