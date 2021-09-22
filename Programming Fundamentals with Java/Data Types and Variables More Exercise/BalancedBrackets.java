package P06_DataTypesAndVariablesMoreExercise;

import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = Long.parseLong(scanner.nextLine());
        long openCount = 0;
        long closeCount = 0;

        for (int i = 1; i <= n; i++) {
            String input = scanner.nextLine();
            if (input.equals("(")) {
                openCount++;

            } else if (input.equals(")")) {
                closeCount++;
                if (openCount - closeCount != 0) {
                    System.out.println("UNBALANCED");
                    return;
                }
            }
        }
        if (openCount == closeCount) {
            System.out.println("BALANCED");
        } else {
            System.out.println("UNBALANCED");
        }
    }
}