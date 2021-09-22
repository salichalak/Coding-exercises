package ConditionalStatementsLab;

import java.util.Scanner;

public class GodzillaVsKong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double budget = Double.parseDouble(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());
        double clothesPriceForOne = Double.parseDouble(scanner.nextLine());

        double clothesTotalPrice = people * clothesPriceForOne;
        double decorationPrice = budget * 0.1;

        if (people > 150) {
            clothesTotalPrice -= clothesTotalPrice * 0.10;
        }

        double costs = clothesTotalPrice + decorationPrice;

        if (budget >= costs) {
            System.out.println("Action!");
            System.out.printf("Wingard starts filming with %.2f leva left.", budget - costs);
        } else if (budget < costs) {
            System.out.println("Not enough money!");
            System.out.printf("Wingard needs %.2f leva more.", Math.abs(budget - costs));
        }
    }
}
