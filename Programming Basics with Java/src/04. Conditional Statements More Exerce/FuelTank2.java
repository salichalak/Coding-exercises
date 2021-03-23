package ConditionalStatementsLab2;

import java.util.Scanner;

public class FuelTank2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String fuel = scanner.nextLine();
        double litres = Double.parseDouble(scanner.nextLine());
        String discountCard = scanner.nextLine();

        double price = 0.0;
        double discount = 0.0;

        if ("Gas".equals(fuel)) {
            if ("Yes".equals(discountCard)) {
                price = litres * (0.93 - 0.08);
            } else if ("No".equals(discountCard)) {
                price = litres * 0.93;
            }
        } else if ("Gasoline".equals(fuel)) {
            if ("Yes".equals(discountCard)) {
                price = litres * (2.22 - 0.18);
            } else if ("No".equals(discountCard)) {
                price = litres * 2.22;
            }
        } else if ("Diesel".equals(fuel)) {
            if ("Yes".equals(discountCard)) {
                price = litres * (2.33 - 0.12);
            } else if ("No".equals(discountCard)) {
                price = litres * 2.33;
            }
        }
        if (litres < 20) {
            price = price * 1;
            System.out.printf("%.2f lv.", price);
        } else if (litres > 20 && litres <= 25) {
            price -= price * 0.08;
            System.out.printf("%.2f lv.", price);
        } else if (litres > 25) {
            price -= price * 0.10;
            System.out.printf("%.2f lv.", price);
        }
    }
}
