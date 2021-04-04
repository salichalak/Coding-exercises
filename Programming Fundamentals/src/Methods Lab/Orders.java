package P10_MethodsLab;

import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (product) {
            case "coffee":
                price = 1.50;
                break;
            case "water":
                price = 1;
                break;
            case "coke":
                price = 1.40;
                break;
            case "snacks":
                price = 2;
                break;
            default:
                price = 0;
        }

        calculatePrice(quantity, price);
    }

    private static void calculatePrice(int quantity, double price) {
        double totalSum = quantity * price;
        System.out.printf("%.2f", totalSum);
    }
}