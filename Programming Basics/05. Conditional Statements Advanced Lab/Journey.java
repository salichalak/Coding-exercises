package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String season = scanner.nextLine();
        double price = 0;

        switch (season) {
            case "summer":
                if (budget <= 100) {
                    price = budget - budget * 0.70;
                    System.out.println("Somewhere in Bulgaria");
                    System.out.printf("Camp - %.2f", price);
                } else if (budget <= 1000) {
                    price = budget - budget * 0.60;
                    System.out.println("Somewhere in Balkans");
                    System.out.printf("Camp - %.2f", price);
                } else {
                    price = budget - budget * 0.10;
                    System.out.println("Somewhere in Europe");
                    System.out.printf("Hotel - %.2f", price);
                }
                break;
            case "winter":
                if (budget <= 100) {
                    price = budget - budget * 0.30;
                    System.out.println("Somewhere in Bulgaria");
                    System.out.printf("Hotel - %.2f", price);
                } else if (budget <= 1000) {
                    price = budget - budget * 0.20;
                    System.out.println("Somewhere in Balkans");
                    System.out.printf("Hotel - %.2f", price);
                } else {
                    price = budget - budget * 0.10;
                    System.out.println("Somewhere in Europe");
                    System.out.printf("Hotel - %.2f", price);
                }
                break;
        }
    }
}