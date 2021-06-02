package StreamsFilesDirectoriesLab;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {

        String path = "C:\\Users\\salichalak\\Desktop\\Advanced\\7. Streams, Files and Directories - Lab\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";

        try {
            FileInputStream filestream = new FileInputStream(path);
            int oneByte = filestream.read();

            while (oneByte != 0) {
                System.out.print(Integer.toBinaryString(oneByte) + " ");
                oneByte = filestream.read();
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}