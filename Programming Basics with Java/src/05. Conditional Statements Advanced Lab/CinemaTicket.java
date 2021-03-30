package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class CinemaTicket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String projection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int columns = Integer.parseInt(scanner.nextLine());
        double price = 0;

        switch (projection) {
            case "Premiere":
                price = 12.00 * rows * columns;
                break;
            case "Normal":
                price = 7.50 * rows * columns;
                break;
            case "Discount":
                price = 5.00 * rows * columns;
        }
        System.out.printf("%.2f leva", price);
    }
}
