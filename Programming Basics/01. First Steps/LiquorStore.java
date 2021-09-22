package FirstSteps;

import java.util.Scanner;

public class LiquorStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double whiskyPrice = Double.parseDouble(scanner.nextLine());
        double beerLitres = Double.parseDouble(scanner.nextLine());
        double wineLitres = Double.parseDouble(scanner.nextLine());
        double rakiaLitres = Double.parseDouble(scanner.nextLine());
        double whiskyLitres = Double.parseDouble(scanner.nextLine());

        double rakiaPrice = whiskyPrice / 2;
        double winePrice = rakiaPrice - (rakiaPrice * 0.40);
        double beerPrice = rakiaPrice - (rakiaPrice * 0.80);

        double rakiaTotalPrice = rakiaLitres * rakiaPrice;
        double wineTotalPrice = wineLitres * winePrice;
        double beerTotalPrice = beerLitres * beerPrice;
        double whiskyTotalPrice = whiskyLitres * whiskyPrice;

        double moneyNeeded = rakiaTotalPrice + wineTotalPrice + beerTotalPrice + whiskyTotalPrice;

        System.out.printf("%.2f", moneyNeeded);
    }
}
