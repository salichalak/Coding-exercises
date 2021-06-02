package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class GetFolderSize {
    public static int countRow = 1;
    public static void main(String[] args) throws IOException {

        String input = "C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\Exercises Resources";
        String outputPath = "outputLine.txt";

        PrintWriter writer = new PrintWriter(outputPath);

        Files.readAllLines(Path.of(input))
                .forEach(line ->
                        writer.println(countRow++ + ". " + line));

        writer.close();
    }
}