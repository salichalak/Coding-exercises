package FirstStepsLab;

import java.util.Scanner;

public class VegetableMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double vegetableKgPrice = Double.parseDouble(scanner.nextLine());
        double fruitKgPrice = Double.parseDouble(scanner.nextLine());
        double vegetableTotalKg = Double.parseDouble(scanner.nextLine());
        double fruitTotalKg = Double.parseDouble(scanner.nextLine());

        double vegetablePrice = vegetableKgPrice * vegetableTotalKg;
        double fruitPrice = fruitKgPrice * fruitTotalKg;

        double totalSumLev = vegetablePrice + fruitPrice;
        double totalSumEuro = totalSumLev / 1.94;

        System.out.printf("%.2f", totalSumEuro);
    }
}
