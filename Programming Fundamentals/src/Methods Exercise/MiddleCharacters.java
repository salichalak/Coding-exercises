package P11_MethodsExercise;

import java.util.Scanner;

public class MiddleCharacters {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        getMiddleCharacter(input);
    }

    private static void getMiddleCharacter(String input) {
        if (input.length() % 2 != 0) {
            System.out.println(input.charAt(input.length() / 2));
        } else {
            char firstChar = input.charAt(input.length() / 2 - 1);
            char secondChar = input.charAt(input.length() / 2);
            System.out.printf("%c%c", firstChar, secondChar);
        }
    }
}