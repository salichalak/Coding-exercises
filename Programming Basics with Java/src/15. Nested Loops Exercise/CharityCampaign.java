package FirstStepsLab;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int campaignDays = Integer.parseInt(scanner.nextLine());
        int chefs = Integer.parseInt(scanner.nextLine());
        int cakes = Integer.parseInt(scanner.nextLine());
        int waffles = Integer.parseInt(scanner.nextLine());
        int pancakes = Integer.parseInt(scanner.nextLine());

        double cakesPrice = cakes * 45;
        double wafflesPrice = waffles * 5.80;
        double pancakesPrice = pancakes * 3.20;

        double totalSumOneDay = (cakesPrice + wafflesPrice + pancakesPrice) * chefs;
        double totalSumCampaign = totalSumOneDay * campaignDays;
        double costs = totalSumCampaign / 8;
        double profit = totalSumCampaign - costs;

        System.out.printf("%.2f", profit);
    }
}
