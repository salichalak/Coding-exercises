package P04_DataTypesAndVariablesLab;

import java.util.Scanner;

public class RefactorSpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        boolean isSpecial = false;

        for (int num = 1; num <= n; num++) {
            int number = num;
            int sum = 0;

            while (number > 0) {
                sum += number % 10;
                number = number / 10;
            }
            isSpecial = (sum == 5) || (sum == 7) || (sum == 11);
            if (isSpecial) {
                System.out.printf("%d -> True%n", num);
            } else {
                System.out.printf("%d -> False%n", num);
            }
        }
    }
}