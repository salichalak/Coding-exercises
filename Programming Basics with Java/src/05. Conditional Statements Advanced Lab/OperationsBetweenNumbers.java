package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();

        int result = 0;
        String oddOrEven = "";
        double dividedResult = 0.0;

        switch (operator) {
            case "+":
                result = n1 + n2;
                if (result % 2 == 0) {
                    oddOrEven = "even";
                } else {
                    oddOrEven = "odd";
                }
                System.out.printf("%d %s %d = %d - %s", n1, operator, n2, result, oddOrEven);
                break;
            case "-":
                result = n1 - n2;
                if (result % 2 == 0) {
                    oddOrEven = "even";
                } else {
                    oddOrEven = "odd";
                }
                System.out.printf("%d %s %d = %d - %s", n1, operator, n2, result, oddOrEven);
                break;
            case "*":
                result = n1 * n2;
                if (result % 2 == 0) {
                    oddOrEven = "even";
                } else {
                    oddOrEven = "odd";
                }
                System.out.printf("%d %s %d = %d - %s", n1, operator, n2, result, oddOrEven);
                break;
            case "/":
                dividedResult = 1.0 * n1 / n2;
                if (n2 != 0) {
                    System.out.printf("%d / %d = %.2f", n1, n2, dividedResult);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
            case "%":
                if (n2 > 0) {
                    dividedResult = n1 % n2;
                    System.out.printf("%d %% %d = %.0f", n1, n2, dividedResult);
                } else {
                    System.out.printf("Cannot divide %d by zero", n1);
                }
                break;
        }
    }
}
