package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int nights = Integer.parseInt(scanner.nextLine());

        double studioPrice = 0;
        double appPrice = 0;

        switch (month) {
            case "May":
            case "October":
                studioPrice = 50 * nights;
                appPrice = 65 * nights;
                break;
            case "June":
            case "September":
                studioPrice = 75.20 * nights;
                appPrice = 68.70 * nights;
                break;
            case "July":
            case "August":
                studioPrice = 76 * nights;
                appPrice = 77 * nights;
        }

        if (nights > 7 && nights <= 14) {
            if ("May".equals(month) || "October".equals(month)) {
                studioPrice -= studioPrice * 0.05;
            }
        } else if (nights > 14) {
            appPrice -= appPrice * 0.10;
            if ("May".equals(month) || "October".equals(month)) {
                studioPrice -= studioPrice * 0.30;
            } else if ("June".equals(month) || "September".equals(month)) {
                studioPrice -= studioPrice * 0.20;
            }
        }
        System.out.printf("Apartment: %.2f lv. %n", appPrice);
        System.out.printf("Studio: %.2f lv.", studioPrice);
    }
}
