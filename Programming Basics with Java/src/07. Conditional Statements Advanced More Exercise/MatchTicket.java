package ConditionalStatementsAdvancedLab2;

import java.util.Scanner;

public class MatchTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        String category = scanner.nextLine();
        int people = Integer.parseInt(scanner.nextLine());

        double ticketPrice = 0;
        double transportPrice = 0;

        if (people >= 1 && people <= 4) {
            transportPrice = budget - budget * 0.25;
        } else if (people >= 5 && people <= 9) {
            transportPrice = budget - budget * 0.40;
        } else if (people >= 10 && people <= 24) {
            transportPrice = budget - budget * 0.50;
        } else if (people >= 25 && people <= 49) {
            transportPrice = budget - budget * 0.60;
        } else {
            transportPrice = budget - budget * 0.75;
        }

        double totalSum = budget - transportPrice;

        if ("Normal".equals(category)) {
            ticketPrice = people * 249.99;
        } else if ("VIP".equals(category)) {
            ticketPrice = people * 499.99;
        }

        if (totalSum >= ticketPrice) {
            double moneyLeft = totalSum - ticketPrice;
            System.out.printf("Yes! You have %.2f leva left.", moneyLeft);
        } else {
            double moneyNeeded = ticketPrice - totalSum;
            System.out.printf("Not enough money! You need %.2f leva.", moneyNeeded);
        }
    }
}
