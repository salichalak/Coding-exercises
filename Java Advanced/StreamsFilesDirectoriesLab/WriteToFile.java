package StreamsFilesDirectoriesLab;

import java.io.*;
import java.util.*;

public class WriteToFile {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";

        FileInputStream inputStream = new FileInputStream(path);

        Set<Character> punctuations = Set.of('.', ',', '!', '?');
        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("WriteToFileOutput.txt");

        while (nextByte != -1) {
            char symbol = (char) nextByte;

            if (!punctuations.contains(symbol)) {
                printStream.print(symbol);
            }

            nextByte = inputStream.read();
        }
    }
}