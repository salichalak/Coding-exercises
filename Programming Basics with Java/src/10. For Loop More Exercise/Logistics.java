package ForLoopLab2;

import java.util.Scanner;

public class Logistics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int cargo = Integer.parseInt(scanner.nextLine());

        double priceMiniBus = 0;
        double priceTruck = 0;
        double priceTrain = 0;

        double sumTonCargoMiniBus = 0;
        double sumTonCargoTruck = 0;
        double sumTonCargoTrain = 0;
        double sumTonCargo = 0;

        for (int i = 1; i <= cargo; i++) {
            int cargoTons = Integer.parseInt(scanner.nextLine());
            sumTonCargo += cargoTons;
            if (cargoTons <= 3) {
                sumTonCargoMiniBus += cargoTons;
                priceMiniBus += cargoTons * 200;
            }
            if (cargoTons > 3 && cargoTons <= 11) {
                sumTonCargoTruck += cargoTons;
                priceTruck += cargoTons * 175;
            }
            if (cargoTons > 11) {
                sumTonCargoTrain += cargoTons;
                priceTrain += cargoTons * 120;
            }
        }
        double sumAveragePrice = (priceMiniBus + priceTruck + priceTrain) / sumTonCargo;
        double percentCargoMinibus = sumTonCargoMiniBus / sumTonCargo * 100;
        double percentCargoTruck = sumTonCargoTruck / sumTonCargo * 100;
        double percentCargoTrain = sumTonCargoTrain / sumTonCargo * 100;

        System.out.printf("%.2f%n", sumAveragePrice);
        System.out.printf("%.2f%%%n", percentCargoMinibus);
        System.out.printf("%.2f%%%n", percentCargoTruck);
        System.out.printf("%.2f%%%n", percentCargoTrain);
    }
}
