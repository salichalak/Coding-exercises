package StreamsFilesDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintStream;

public class CopyBytes {
    public static void main(String[] args) throws IOException {

        String path = "input.txt";
        FileInputStream inputStream = new FileInputStream(path);
        int nextByte = inputStream.read();

        PrintStream printStream = new PrintStream("CopyBytesOutput.txt");

        while (nextByte != -1) {
            if (nextByte == ' ') {
                printStream.print((char) nextByte);
            } else if (nextByte == 10) {
                printStream.println();
            } else if (nextByte != 13){
                printStream.print(nextByte);
            }

            nextByte = inputStream.read();
        }
    }
}