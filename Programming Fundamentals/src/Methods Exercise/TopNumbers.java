package P11_MethodsExercise;

import java.util.Scanner;

public class TopNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        printTopNumbers(n);
    }

    private static void printTopNumbers(int n) {
        for (int i = 1; i <= n; i++) {
            int number = i;
            int sum = 0;
            boolean isOdd = false;

            while (number != 0) {
                int currentDigit = number % 10;
                sum += currentDigit;

                if (currentDigit % 2 != 0) {
                    isOdd = true;
                }
                number = number / 10;
            }
            if (sum % 8 == 0 && isOdd) {
                System.out.println(i);
            }
        }
    }
}