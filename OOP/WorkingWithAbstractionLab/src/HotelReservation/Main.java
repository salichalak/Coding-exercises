package HotelReservation;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        double pricePerDay = Double.parseDouble(tokens[0]);
        int days = Integer.parseInt(tokens[1]);
        Season season = Season.valueOf(tokens[2].toUpperCase());
        Discount discount = Discount.parseDiscount(tokens[3]);

        PriceCalculator priceCalculator = new PriceCalculator(pricePerDay, days, season, discount);

        System.out.printf("%.2f%n", priceCalculator.calculatePrice());
    }
}