package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class SkiTrip {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int days = Integer.parseInt(scanner.nextLine());
        String room = scanner.nextLine();
        String opinion = scanner.nextLine();

        int nights = days - 1;
        double price = 0;

        switch (room) {
            case "room for one person":
                price = 18;
                break;
            case "apartment":
                if (days < 10) {
                    price = 25 * 0.70;
                } else if (days > 10 && days < 15) {
                    price = 25 * 0.65;
                } else if (days > 15) {
                    price = 25 * 0.50;
                }
                break;
            case "president apartment":
                if (days < 10) {
                    price = 35 * 0.90;
                } else if (days > 10 && days < 15) {
                    price = 35 * 0.85;
                } else if (days > 15) {
                    price = 35 * 0.80;
                }
                break;
        }
        if ("positive".equals(opinion)) {
            price += price * 0.25;
        } else if ("negative".equals(opinion)) {
            price -= price * 0.10;
        }
        double finalPrice = nights * price;
        System.out.printf("%.2f", finalPrice);
    }
}
