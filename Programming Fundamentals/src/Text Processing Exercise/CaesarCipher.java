package P23_TextProcessingExercise;

import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String text = scanner.nextLine();
        StringBuilder encrypted = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentSymbol = (char) (text.charAt(i) + 3);

            encrypted.append(currentSymbol);
        }

        System.out.println(encrypted);
    }
}