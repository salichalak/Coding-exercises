package ConditionalStatementsAdvancedLab2;

import java.util.Scanner;

public class FlowerShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int chrysanthemums = Integer.parseInt(scanner.nextLine());
        int roses = Integer.parseInt(scanner.nextLine());
        int tulips = Integer.parseInt(scanner.nextLine());
        String season = scanner.nextLine();
        String holiday = scanner.nextLine();

        double chrysanthemumsPrice = 0.0;
        double rosesPrice = 0.0;
        double tulipsPrice = 0.0;
        double bucketPrice = 0.0;

        switch (season) {
            case "Spring":
            case "Summer":
                chrysanthemumsPrice = chrysanthemums * 2.0;
                rosesPrice = roses * 4.10;
                tulipsPrice = tulips * 2.50;
                bucketPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;
                break;
            case "Autumn":
            case "Winter":
                chrysanthemumsPrice = chrysanthemums * 3.75;
                rosesPrice = roses * 4.50;
                tulipsPrice = tulips * 4.15;
                bucketPrice = chrysanthemumsPrice + rosesPrice + tulipsPrice;
        }
        if ("Y".equals(holiday)) {
            bucketPrice += bucketPrice * 0.15;
        }
        int flowersTotal = chrysanthemums + roses + tulips;

        if (tulips > 7 && "Spring".equals(season)) {
            bucketPrice -= bucketPrice * 0.05;
        } else if (roses >= 10 && "Winter".equals(season)) {
            bucketPrice -= bucketPrice * 0.10;
        }
        if (flowersTotal > 20) {
            bucketPrice -= bucketPrice * 0.20;
            System.out.printf("%.2f", bucketPrice + 2);
        } else {
            System.out.printf("%.2f", bucketPrice + 2);
        }
    }
}
