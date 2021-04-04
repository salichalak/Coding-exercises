package P02_BasicSyntaxExercise;

import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String username = scanner.nextLine();
        String reversed = new StringBuilder(username).reverse().toString();
        int counter = 0;

        String currentPassword = scanner.nextLine();
        while (!currentPassword.equals(reversed)) {
            counter++;
            if (counter == 4) {
                System.out.printf("User %s blocked!", username);
                break;
            }
            System.out.println("Incorrect password. Try again.");
            currentPassword = scanner.nextLine();
        }
        if (currentPassword.equals(reversed)) {
            System.out.printf("User %s logged in.", username);
        }
    }
}