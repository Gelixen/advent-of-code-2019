package day4;

import org.junit.jupiter.api.Test;

import static day4.Password.calculate;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PasswordTest {

    @Test
    void testCase1() {
        assertEquals(1, calculate("111111-111111"));
    }

    @Test
    void testCase2() {
        assertEquals(9, calculate("111111-111119"));
    }

    @Test
    void testCase3() {
        assertEquals(5, calculate("123455-123499"));
    }
}