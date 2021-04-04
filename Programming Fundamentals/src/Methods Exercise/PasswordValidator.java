package P11_MethodsExercise;

import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        if (!validateLength(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!validateContent(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!validateDigitsCount(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (validateLength(password) && validateContent(password) && validateDigitsCount(password)) {
            System.out.println("Password is valid");
        }
    }

    static boolean validateLength(String password) {
        return password.length() >= 6 && password.length() <= 10;
    }

    static boolean validateContent(String password) {
        for (int index = 0; index < password.length(); index++) {
            char currentSymbol = password.charAt(index);
            boolean isSmallLetter = currentSymbol >= 97 && currentSymbol <= 122;
            boolean isCapitalLetter = currentSymbol >= 65 && currentSymbol <= 90;
            boolean isDigit = currentSymbol >= 48 && currentSymbol <= 57;

            if (!isSmallLetter && !isCapitalLetter && !isDigit) {
                return false;
            }
        }
        return true;
    }

    static boolean validateDigitsCount(String password) {
        int countDigits = 0;

        for (int index = 0; index < password.length(); index++) {
            char currentSymbol = password.charAt(index);
            if (Character.isDigit(currentSymbol)) {
                countDigits++;
            }
        }
        return countDigits >= 2;
    }
}