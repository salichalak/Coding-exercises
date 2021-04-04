package P11_MethodsExercise;

import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();
        while (!command.equals("END")) {

            System.out.println(isPalindrome(command));

            command = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(String numberAsString) {
        StringBuilder builderLeft = new StringBuilder();
        for (int left = 0; left < numberAsString.length(); left++) {
            builderLeft.append(numberAsString.charAt(left));
        }

        StringBuilder builderRight = new StringBuilder();
        for (int right = numberAsString.length() - 1; right >= 0; right--) {
            builderRight.append(numberAsString.charAt(right));
        }

        return builderLeft.toString().equals(builderRight.toString());
    }
}