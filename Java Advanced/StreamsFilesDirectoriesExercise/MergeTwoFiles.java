package StreamsFilesDirectoriesExercise;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {

        Path firstPath = Path.of("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputOne.txt");
        Path secondPath = Path.of("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\inputTwo.txt");
        PrintWriter writer = new PrintWriter("C:\\Users\\salichalak\\Downloads\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\merge.txt");

        List<String> linesFirstFile = Files.readAllLines(firstPath);
        List<String> linesSecondFile = Files.readAllLines(secondPath);


        linesFirstFile.forEach(writer::println);
        linesSecondFile.forEach(writer::println);

        writer.close();
    }
}