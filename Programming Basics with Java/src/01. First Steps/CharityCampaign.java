package FirstSteps;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int campaignDays = Integer.parseInt(scanner.nextLine());
        int cooksCount = Integer.parseInt(scanner.nextLine());
        int cakesCount = Integer.parseInt(scanner.nextLine());
        int wafflesCount = Integer.parseInt(scanner.nextLine());
        int pancakesCount = Integer.parseInt(scanner.nextLine());

        int cakePrice = 45;
        double wafflePrice = 5.80;
        double pancakePrice = 3.20;

        double pricePerDayForCakes = cakesCount * cakePrice;
        double pricePerDayForWaffles = wafflesCount * wafflePrice;
        double pricePerDayForPancakes = pancakesCount * pancakePrice;
        double totalSumForAllCooks = (pricePerDayForCakes + pricePerDayForWaffles + pricePerDayForPancakes) * cooksCount;

        double totalSumForCampaign = totalSumForAllCooks * campaignDays;
        double productsCost = totalSumForCampaign / 8;
        double totalSumWithoutCosts = totalSumForCampaign - productsCost;
        System.out.printf("%.2f", totalSumWithoutCosts);
    }
}