package P02_BasicSyntaxExercise;

import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        double coins = 0;

        while (!input.equals("Start")) {
            double coin = Double.parseDouble(input);
            if (coin == 0.1 || coin == 0.2 || coin == 0.5 || coin == 1 || coin == 2) {
                coins += coin;
            } else {
                System.out.printf("Cannot accept %.2f%n", coin);
            }
            input = scanner.nextLine();
        }

        String product = scanner.nextLine();
        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    if (coins >= 2) {
                        System.out.printf("Purchased %s%n", product);
                        coins -= 2;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Water":
                    if (coins >= 0.7) {
                        System.out.printf("Purchased %s%n", product);
                        coins -= 0.7;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Crisps":
                    if (coins >= 1.5) {
                        System.out.printf("Purchased %s%n", product);
                        coins -= 1.5;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Soda":
                    if (coins >= 0.8) {
                        System.out.printf("Purchased %s%n", product);
                        coins -= 0.8;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                case "Coke":
                    if (coins >= 1) {
                        System.out.printf("Purchased %s%n", product);
                        coins -= 1;
                    } else {
                        System.out.println("Sorry, not enough money");
                    }
                    break;
                default:
                    System.out.println("Invalid product");
            }
            product = scanner.nextLine();
        }
        System.out.printf("Change: %.2f", coins);
    }
}