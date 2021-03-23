package FirstSteps;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double tripPrice = Double.parseDouble(scanner.nextLine());
        int puzzlesCount = Integer.parseInt(scanner.nextLine());
        int dollsCount = Integer.parseInt(scanner.nextLine());
        int bearsCount = Integer.parseInt(scanner.nextLine());
        int minionsCount = Integer.parseInt(scanner.nextLine());
        int trucksCount = Integer.parseInt(scanner.nextLine());

        double puzzlePrice = 2.60;
        double dollPrice = 3.0;
        double bearPrice = 4.10;
        double minionPrice = 8.20;
        double truckPrice = 2.0;

        int toysTotalCount = puzzlesCount + dollsCount + bearsCount + minionsCount + trucksCount;
        double toysTotalPrice = (puzzlePrice * puzzlesCount) + (dollPrice * dollsCount)
                + (bearPrice * bearsCount) + (minionPrice * minionsCount) + (truckPrice * trucksCount);

        double shopRent =  toysTotalPrice - (toysTotalPrice * 0.10) ;

        if (toysTotalCount >= 50) {
            toysTotalPrice = toysTotalPrice - (toysTotalPrice * 0.25);
        }

        double profit = toysTotalPrice - shopRent;

        if (profit >= tripPrice) {
            System.out.printf("Yes! %.2f lv left.", profit - tripPrice);
        } else if (profit < tripPrice) {
            System.out.printf("Not enough money! %.2f lv needed.", tripPrice - profit);
        }
    }
}
