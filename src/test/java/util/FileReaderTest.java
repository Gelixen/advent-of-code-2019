package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static util.FileReader.readInput;

class FileReaderTest {

    @Test
    void readSingleLine() {
        assertEquals("test-data", readInput("test"));
    }

    @Test
    void readMultipleLines() {
        assertEquals("test-line-1\ntest-line-2\ntest-line-3", readInput("test2"));
    }

}