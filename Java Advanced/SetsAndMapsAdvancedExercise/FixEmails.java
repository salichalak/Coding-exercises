package SetsAndMapsAdvancedExercise;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashMap<String, String> emails = new LinkedHashMap<>();
        String name = scanner.nextLine();

        while (!name.equals("stop")) {
            String email = scanner.nextLine();

            if (isValid(name, email, emails)) {
                emails.put(name, email);
            }

            name = scanner.nextLine();
        }

        emails.forEach((k, v) -> System.out.println(k + " -> " + v));
    }

    private static boolean isValid(String name, String email, LinkedHashMap<String, String> emails) {
        return !emails.containsKey(name) && !email.endsWith("us") && !email.endsWith("uk") && !email.endsWith("com");
    }
}