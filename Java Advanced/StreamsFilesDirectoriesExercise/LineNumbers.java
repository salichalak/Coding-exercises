package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputLineNumbers.txt");
        List<String> lines = Files.readAllLines(path);
        PrintWriter writer = new PrintWriter("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\outputLines.txt");

        int row = 1;
        for (String line : lines) {
            writer.println(row++ + ". " + line);
        }

        writer.close();
    }
}