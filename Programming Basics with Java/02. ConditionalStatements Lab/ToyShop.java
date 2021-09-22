package ConditionalStatements;

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

        double puzzlesSum = puzzlesCount * 2.60;
        double dollsSum = dollsCount * 3;
        double bearsSum = bearsCount * 4.10;
        double minionsSum = minionsCount * 8.20;
        double trucksSum = trucksCount * 2;

        double toysTotalSum = puzzlesSum + dollsSum + bearsSum + minionsSum + trucksSum;
        int toysTotalCount = puzzlesCount + dollsCount + bearsCount + minionsCount + trucksCount;

        if (toysTotalCount >= 50) {
            double discount = toysTotalSum * 0.25;
            toysTotalSum = toysTotalSum - discount;
        }

        double shopRent = toysTotalSum * 0.10;
        double profit = toysTotalSum - shopRent;

       if (profit >= tripPrice) {
           double moneyLeft = profit - tripPrice;
            System.out.printf("Yes! %.2f lv left.", moneyLeft);
        } else if (profit < tripPrice) {
           double moneyNeeded = tripPrice - profit;
           System.out.printf("Not enough money! %.2f lv needed.", moneyNeeded);
        }
    }
}