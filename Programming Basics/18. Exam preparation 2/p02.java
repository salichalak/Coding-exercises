package Test;

import java.util.Scanner;

public class p02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int nights = Integer.parseInt(scanner.nextLine());
        double priceForNight = Double.parseDouble(scanner.nextLine());
        int percent = Integer.parseInt(scanner.nextLine());

        if (nights > 7) {
            priceForNight = priceForNight * 0.95;
        }
        double totalCost = budget * percent * 0.01 + priceForNight * nights;

        if (budget >= totalCost) {
            double moneyLeft = budget - totalCost;
            System.out.printf("Ivanovi will be left with %.2f leva after vacation.", moneyLeft);
        } else {
            double moneyNeeded = totalCost - budget;
            System.out.printf("%.2f leva needed.", moneyNeeded);
        }
    }
}
