package StreamsFilesDirectoriesExercise;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class AllCapitals {
    public static void main(String[] args) throws IOException {

        Path inputPath = Path.of("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        List<String> lines = Files.readAllLines(inputPath);
        File outputFile = new File("C:\\\\Users\\\\salichalak\\\\Downloads\\\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\\\output.txt");

        PrintWriter writer = new PrintWriter(outputFile);
        lines.forEach(line -> {
            writer.println(line.toUpperCase());
        });
        writer.close();
    }
}