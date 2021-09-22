package P27_ExamPreparation2;

import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine();
        String input = scanner.nextLine();

        while (!input.equals("Done")) {
            String[] tokens = input.split("\\s+");
            String command = tokens[0];

            switch (command) {
                case "TakeOdd":
                    password = takeOdd(password);
                    System.out.println(password);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int length = Integer.parseInt(tokens[2]);
                    String substringToRemove = password.substring(startIndex, startIndex + length);
                    password = password.replaceFirst(substringToRemove, "");
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = tokens[1];
                    String substitute = tokens[2];
                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine();
        }

        System.out.println("Your password is: " + password);
    }

    private static String takeOdd(String password) {
        StringBuilder newPassword = new StringBuilder();
        for (int index = 1; index <= password.length() - 1; index += 2) {
            char currentSymbol = password.charAt(index);
            newPassword.append(currentSymbol);
        }
        return newPassword.toString();
    }
}