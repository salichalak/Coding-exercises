package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();
        double price = 0;

        if ("Monday".equals(day) || "Tuesday".equals(day) || "Friday".equals(day)) {
            price = 12;
        } else if ("Wednesday".equals(day) || "Thursday".equals(day)){
            price = 14;
        } else if ("Saturday".equals(day) || "Sunday".equals(day)) {
            price = 16;
        }
        System.out.printf("%.0f", price);
    }
}
