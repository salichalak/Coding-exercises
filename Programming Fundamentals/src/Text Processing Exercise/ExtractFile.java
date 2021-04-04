package P23_TextProcessingExercise;

import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] inputAsArray = input.split("\\\\");
        String file = inputAsArray[inputAsArray.length - 1];

        String fileName = file.substring(0, file.lastIndexOf('.'));
        String fileExtension = file.substring(file.lastIndexOf('.') + 1);

        System.out.println("File name: " + fileName);
        System.out.println("File extension: " + fileExtension);
    }
}