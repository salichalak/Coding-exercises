package Exam28and29March;

import java.util.Scanner;

public class SuppliesForSchool {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int packsPen = Integer.parseInt(scanner.nextLine());
        int packsMarker = Integer.parseInt(scanner.nextLine());
        double detergentLitres = Double.parseDouble(scanner.nextLine());
        int discountPercent = Integer.parseInt(scanner.nextLine());

        double priceForSupplies = packsPen * 5.80 + packsMarker * 7.20 + detergentLitres * 1.20;
        double discount = priceForSupplies * (discountPercent * 0.01);
        double moneyNeeded = priceForSupplies - discount;

        System.out.printf("%.3f", moneyNeeded);
    }
}
