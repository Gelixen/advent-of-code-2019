package day1;

import org.junit.jupiter.api.Test;

import static day1.RocketFuel.calculateFuel;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RocketFuelTest {

    @Test
    void testCase1() {
        assertEquals(2, calculateFuel(12));
    }

    @Test
    void testCase2() {
        assertEquals(2, calculateFuel(14));
    }

    @Test
    void testCase3() {
        assertEquals(654, calculateFuel(1969));
    }

    @Test
    void testCase4() {
        assertEquals(33583, calculateFuel(100756));
    }
}