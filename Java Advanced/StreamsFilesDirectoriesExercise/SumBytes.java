package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class SumBytes {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        byte[] values = Files.readAllBytes(filePath);
        long sum = 0;

        for (byte byteValue : values) {
            if (byteValue == 10 || byteValue == 13) {
                continue;
            }
            sum += byteValue;
        }

        System.out.println(sum);
    }
}