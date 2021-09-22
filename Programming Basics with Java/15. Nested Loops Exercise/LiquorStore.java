package FirstStepsLab;

import java.util.Scanner;

public class LiquorStore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double whiskyPricePerLiter = Double.parseDouble(scanner.nextLine());
        double beerLiters = Double.parseDouble(scanner.nextLine());
        double wineLiters = Double.parseDouble(scanner.nextLine());
        double rakiaLiters = Double.parseDouble(scanner.nextLine());
        double whiskyLiters = Double.parseDouble(scanner.nextLine());

        double rakiaPricePerLiter = whiskyPricePerLiter / 2;
        double winePricePerLiter = rakiaPricePerLiter - rakiaPricePerLiter * 0.40;
        double beerPricePerLiter = rakiaPricePerLiter - rakiaPricePerLiter * 0.80;

        double rakiaSum = rakiaPricePerLiter * rakiaLiters;
        double wineSum = winePricePerLiter * wineLiters;
        double beerSum = beerPricePerLiter * beerLiters;
        double whiskySum = whiskyPricePerLiter * whiskyLiters;

        double totalSum = rakiaSum + wineSum + beerSum + whiskySum;
        System.out.printf("%.2f", totalSum);
    }
}
