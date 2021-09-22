package FinalExam;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder text = new StringBuilder(scanner.nextLine());
        String input = scanner.nextLine();

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String command = tokens[0];

            switch (command) {
                case "Translate":
                    String old = tokens[1];
                    String replacement = tokens[2];
                    String replaced = text.toString().replace(old, replacement);
                    text = new StringBuilder(replaced);
                    System.out.println(text);
                    break;

                case "Includes":
                    String textToCheck = tokens[1];
                    if (text.toString().contains(textToCheck)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Start":
                    String startString = tokens[1];
                    if (text.substring(0, startString.length()).equals(startString)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;

                case "Lowercase":
                    String toLowerCase = text.toString().toLowerCase();
                    text = new StringBuilder(toLowerCase);
                    System.out.println(text);
                    break;

                case "FindIndex":
                    String index = tokens[1];
                    System.out.println(text.lastIndexOf(index));
                    break;

                case "Remove":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    StringBuilder removeSubstring = text.replace(startIndex, endIndex, "");
                    System.out.println(removeSubstring);
                    break;
            }

            input = scanner.nextLine();
        }

    }
}