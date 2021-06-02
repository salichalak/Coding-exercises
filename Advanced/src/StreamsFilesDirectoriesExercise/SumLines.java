package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SumLines {
    public static void main(String[] args) throws IOException {

        Path filePath = Path.of("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = Files.readAllLines(filePath);

        lines.stream().map(line -> line.toCharArray()).forEach(charArray -> {
            int sum = 0;
            for (char symbol : charArray) {
                sum += symbol;
            }
            System.out.println(sum);
        });
    }
}