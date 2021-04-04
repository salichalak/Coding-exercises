package P06_DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class DecryptingMessage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = Integer.parseInt(scanner.nextLine());
        int lines = Integer.parseInt(scanner.nextLine());
        char currentChar = ' ';
        String decryptedMessage = "";

        for (int i = 1; i <= lines; i++) {
            currentChar = scanner.nextLine().charAt(0);
            currentChar = (char) (currentChar + key);

            decryptedMessage = decryptedMessage.concat(Character.toString(currentChar));
        }
        System.out.println(decryptedMessage);
    }
}