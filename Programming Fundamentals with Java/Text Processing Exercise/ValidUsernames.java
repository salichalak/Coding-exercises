package P23_TextProcessingExercise;

import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] usernames = scanner.nextLine().split(", ");

        for (String username : usernames) {
            if (isValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean isValid(String username) {
        boolean isValid = false;

        if (username.length() >= 3 && username.length() <= 16) {
            isValid = true;
        }

        if (isValid) {
            for (int i = 0; i < username.length(); i++) {
                char currentSymbol = username.charAt(i);

                if (!Character.isLetterOrDigit(currentSymbol) && currentSymbol != '-' && currentSymbol != '_') {
                    isValid = false;
                }
            }
        }
        return isValid;
    }

}