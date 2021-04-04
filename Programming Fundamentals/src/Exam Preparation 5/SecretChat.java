package P30_ExamPreparation5;

import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder concealed = new StringBuilder(scanner.nextLine());
        String userInput;

        while (!"Reveal".equals(userInput = scanner.nextLine())) {
            String[] tokens = userInput.split(":\\|:");
            String command = tokens[0];

            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(tokens[1]);
                    String input = " ";
                    concealed.insert(index, input);
                    System.out.println(concealed);
                    break;
                case "Reverse":
                    String substring = tokens[1];
                    String message = concealed.toString();

                    if (message.contains(substring)) {
                        String reversed = new StringBuilder(substring).reverse().toString();
                        int endIndex = message.indexOf(substring);
                        String output = message.substring(0, endIndex);
                        output += reversed;
                        concealed = new StringBuilder(output);
                        System.out.println(concealed);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    String oldInput = tokens[1];
                    String newInput = tokens[2];
                    String revealedAsString = concealed.toString();
                    revealedAsString = revealedAsString.replace(oldInput, newInput);
                    concealed = new StringBuilder(revealedAsString);
                    System.out.println(concealed);
                    break;
            }
        }

        System.out.println("You have a new text message: " + concealed);
    }
}