package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class FruitShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fruit = scanner.nextLine();
        String day = scanner.nextLine();
        double quantity = Double.parseDouble(scanner.nextLine());
        double price = 0.0;

        if ("Monday".equals(day) || "Tuesday".equals(day) || "Wednesday".equals(day) || "Thursday".equals(day) || "Friday".equals(day)) {
            if ("banana".equals(fruit)) {
                price = 2.50 * quantity;
            } else if ("apple".equals(fruit)) {
                price = 1.20 * quantity;
            } else if ("orange".equals(fruit)) {
                price = 0.85 * quantity;
            } else if ("grapefruit".equals(fruit)) {
                price = 1.45 * quantity;
            } else if ("kiwi".equals(fruit)) {
                price = 2.70 * quantity;
            } else if ("pineapple".equals(fruit)) {
                price = 5.50 * quantity;
            } else if ("grapes".equals(fruit)) {
                price = 3.85 * quantity;
            }
        } else if ("Saturday".equals(day) || "Sunday".equals(day)) {
            if ("banana".equals(fruit)) {
                price = 2.70 * quantity;
            } else if ("apple".equals(fruit)) {
                price = 1.25 * quantity;
            } else if ("orange".equals(fruit)) {
                price = 0.90 * quantity;
            } else if ("grapefruit".equals(fruit)) {
                price = 1.60 * quantity;
            } else if ("kiwi".equals(fruit)) {
                price = 3.00 * quantity;
            } else if ("pineapple".equals(fruit)) {
                price = 5.60 * quantity;
            } else if ("grapes".equals(fruit)) {
                price = 4.20 * quantity;
            }
        }
        if (price > 0) {
            System.out.printf("%.2f", price);
        } else {
            System.out.println("error");
        }
    }
}
