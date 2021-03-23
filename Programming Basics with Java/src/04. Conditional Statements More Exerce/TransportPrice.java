package ConditionalStatementsLab2;

import java.util.Scanner;

public class TransportPrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int kilometers = Integer.parseInt(scanner.nextLine());
        String dayTime = scanner.nextLine();
        double price = 0.0;

        if (kilometers < 20 && kilometers > 0) {
            if ("day".equals(dayTime)) {
                price = (kilometers * 0.79) + 0.70;
            } else if ("night".equals(dayTime)) {
                price = (kilometers * 0.90) + 0.70;
            }
        } else if (kilometers >= 20 && kilometers < 100) {
            if ("day".equals(dayTime) || "night".equals(dayTime)) {
                price = kilometers * 0.09;
            }
        } else if (kilometers >= 100) {
            if ("day".equals(dayTime) || "night".equals(dayTime)) {
                price = kilometers * 0.06;
            }
        }
        System.out.printf("%.2f", price);
    }
}
