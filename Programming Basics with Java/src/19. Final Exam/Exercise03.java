package Pb_Exam_Online;

import java.util.Scanner;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String month = scanner.nextLine();
        int hoursWasted = Integer.parseInt(scanner.nextLine());
        int peopleInGroup = Integer.parseInt(scanner.nextLine());
        String dayOrNight = scanner.nextLine();
        double priceForHour = 0.0;

        switch (month) {
            case "march":
            case "april":
            case "may":
                if ("day".equals(dayOrNight)) {
                    priceForHour = 10.50;
                } else if ("night".equals(dayOrNight)) {
                    priceForHour = 8.40;
                }
                break;
            case "june":
            case "july":
            case "august":
                if ("day".equals(dayOrNight)) {
                    priceForHour = 12.60;
                } else if ("night".equals(dayOrNight)) {
                    priceForHour = 10.20;
                }
			default:
                break;
        }
		
        if (peopleInGroup >= 4) {
            priceForHour = priceForHour * 0.90;
        }
		
        if (hoursWasted >= 5) {
            priceForHour = priceForHour / 2;
        }
		
        double totalSum = (priceForHour * peopleInGroup) * hoursWasted;
        System.out.printf("Price per person for one hour: %.2f%n", priceForHour);
        System.out.printf("Total cost of the visit: %.2f", totalSum);
    }
}