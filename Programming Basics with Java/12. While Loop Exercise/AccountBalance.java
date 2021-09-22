package WhileLoop;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double total = 0;

        while (!"NoMoreMoney".equals(input)) {
            double amount = Double.parseDouble(input);
            if (amount < 0) {
                System.out.println("Invalid operation!");
                break;
            }
            if (amount > 0) {
                System.out.printf("Increase: %.2f%n", amount);
                total += amount;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Total: %.2f", total);
    }
}
