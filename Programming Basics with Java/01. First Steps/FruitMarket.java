package FirstSteps;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberryPriceKg = Double.parseDouble(scanner.nextLine());
        double bananasCountKg = Double.parseDouble(scanner.nextLine());
        double orangesCountKg = Double.parseDouble(scanner.nextLine());
        double raspberryCountKg = Double.parseDouble(scanner.nextLine());
        double strawberryCountKg = Double.parseDouble(scanner.nextLine());

        double raspberryPriceKg = strawberryPriceKg - (strawberryPriceKg * 0.50);
        double orangesPriceKg = raspberryPriceKg - (raspberryPriceKg * 0.40);
        double bananasPriceKg = raspberryPriceKg - (raspberryPriceKg * 0.80);

        double totalPriceRaspberry = raspberryCountKg * raspberryPriceKg;
        double totalPriceOranges = orangesCountKg * orangesPriceKg;
        double totalPriceStrawberry = strawberryCountKg * strawberryPriceKg;
        double totalPriceBananas = bananasCountKg * bananasPriceKg;

        double totalPrice = totalPriceRaspberry + totalPriceOranges + totalPriceStrawberry + totalPriceBananas;

        System.out.printf("%.2f", totalPrice);
    }
}