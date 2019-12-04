package util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReader {
    public static String readInput(String day) {
        String path = ClassLoader.getSystemClassLoader()
                .getResource(day + "/input.txt")
                .getPath();

        try {
            return Files.readString(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }
}
