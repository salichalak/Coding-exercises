package ConditionalStatementsAdvancedLab2;

import java.util.Scanner;

public class Bikerace {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bikersJr = Integer.parseInt(scanner.nextLine());
        int bikersSr = Integer.parseInt(scanner.nextLine());
        String route = scanner.nextLine();

        double taxJunior = 0;
        double taxSenior = 0;
        int bikersTotal = bikersJr + bikersSr;

        switch (route) {
            case "trail":
                taxJunior = bikersJr * 5.50;
                taxSenior = bikersSr * 7;
                break;
            case "cross-country":
                taxJunior = bikersJr * 8;
                taxSenior = bikersSr * 9.50;
                break;
            case "downhill":
                taxJunior = bikersJr * 12.25;
                taxSenior = bikersSr * 13.75;
                break;
            case "road":
                taxJunior = bikersJr * 20;
                taxSenior = bikersSr * 21.50;
                break;
        }

        double totalSumBikers = taxJunior + taxSenior;
        double costs = (totalSumBikers - totalSumBikers * 0.50) / 10;
        double moneyLeft = totalSumBikers - costs;

        if ("cross-country".equals(route) && bikersTotal >= 50) {
            moneyLeft -= moneyLeft * 0.25;
            System.out.printf("%.2f", moneyLeft);
        } else {
            System.out.printf("%.2f", moneyLeft);
        }
    }
}
