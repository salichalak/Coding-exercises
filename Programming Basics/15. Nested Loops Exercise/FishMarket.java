package FirstStepsLab;

import java.util.Scanner;

public class FishMarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double mackerelPriceKg = Double.parseDouble(scanner.nextLine());
        double spratPriceKg = Double.parseDouble(scanner.nextLine());
        double bonitoKg = Double.parseDouble(scanner.nextLine());
        double scadKg = Double.parseDouble(scanner.nextLine());
        int musselKg = Integer.parseInt(scanner.nextLine());

        double bonitoPriceKg = mackerelPriceKg + mackerelPriceKg * 0.60;
        double bonitoSum = bonitoPriceKg * bonitoKg;
        double scadPriceKg = spratPriceKg + spratPriceKg * 0.80;
        double scadSum = scadPriceKg * scadKg;
        double musselSum = musselKg * 7.50;

        double totalSum = bonitoSum + scadSum + musselSum;
        System.out.printf("%.2f", totalSum);
    }
}
