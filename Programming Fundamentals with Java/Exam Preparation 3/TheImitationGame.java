package P28_ExamPreparation3;

import java.util.Scanner;

public class TheImitationGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String encryptedMessage = scanner.nextLine();
        StringBuilder decryptedMessage = new StringBuilder(encryptedMessage);
        String input = scanner.nextLine();

        while (!input.equals("Decode")) {
            String[] commandParts = input.split("\\|");
            String command = commandParts[0];

            switch (command) {
                case "Move":
                    int lettersCount = Integer.parseInt(commandParts[1]);
                    String decryptedMessageAsString = decryptedMessage.toString();
                    String removedLetters = decryptedMessage.substring(0, lettersCount);
                    decryptedMessageAsString = decryptedMessageAsString.substring(lettersCount);
                    decryptedMessageAsString += removedLetters;
                    decryptedMessage = new StringBuilder(decryptedMessageAsString);
                    break;

                case "Insert":
                    int indexToInsert = Integer.parseInt(commandParts[1]);
                    String insertInput = commandParts[2];
                    decryptedMessage.insert(indexToInsert, insertInput);
                    break;

                case "ChangeAll":
                    String inputToReplace = commandParts[1];
                    String inputToInsert = commandParts[2];
                    String messageAsString = decryptedMessage.toString();
                    messageAsString = messageAsString.replace(inputToReplace, inputToInsert);
                    decryptedMessage = new StringBuilder(messageAsString);
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("The decrypted message is: " + decryptedMessage);
    }
}