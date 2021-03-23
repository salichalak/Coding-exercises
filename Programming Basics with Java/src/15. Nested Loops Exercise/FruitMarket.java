package FirstStepsLab;

import java.util.Scanner;

public class FruitMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double strawberryPriceKg = Double.parseDouble(scanner.nextLine());
        double bananas = Double.parseDouble(scanner.nextLine());
        double oranges = Double.parseDouble(scanner.nextLine());
        double raspberries = Double.parseDouble(scanner.nextLine());
        double strawberries = Double.parseDouble(scanner.nextLine());

        double raspberriesPriceKg = strawberryPriceKg / 2;
        double orangesPriceKg = raspberriesPriceKg - raspberriesPriceKg * 0.40;
        double bananasPriceKg = raspberriesPriceKg - raspberriesPriceKg * 0.80;

        double raspberriesSum = raspberriesPriceKg * raspberries;
        double orangesSum = orangesPriceKg * oranges;
        double bananaSum = bananasPriceKg * bananas;
        double strawberriesSum = strawberryPriceKg * strawberries;

        double neededSum = raspberriesSum + orangesSum + bananaSum + strawberriesSum;
        System.out.printf("%.2f", neededSum);
    }
}
