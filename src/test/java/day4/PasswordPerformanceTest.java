package day4;

import org.junit.jupiter.api.RepeatedTest;

import java.util.function.Supplier;

import static day4.Password.calculate;
import static day4.Password.calculateAlternative;

public class PasswordPerformanceTest {

    private static final String RANGE = "1000000000-1005000000";
    private static final int WARMUP_COUNT = 10;
    private static final int TEST_COUNT = 100;

    @RepeatedTest(5)
    void testUsingStandardCalculation() {
        executeTest(() -> calculate(RANGE));
    }

    @RepeatedTest(5)
    void testUsingAlternativeCalculation() {
        executeTest(() -> calculateAlternative(RANGE));
    }

    private void executeTest(Supplier<Long> calculation) {
        for (int i = 0; i < WARMUP_COUNT; i++) {
            calculation.get();
        }

        long average = 0;

        for (int i = 0; i < TEST_COUNT; i++) {
            long start = System.currentTimeMillis();
            calculation.get();
            long finish = System.currentTimeMillis();

            average += finish - start;
        }

        System.out.println(average / TEST_COUNT);
    }

}
