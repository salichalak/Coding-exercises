package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String year = scanner.nextLine();
        double holidays = Double.parseDouble(scanner.nextLine());
        double weekends = Double.parseDouble(scanner.nextLine());

        double weekendsInSofia = (48 - weekends) * 3 / 4;
        double holidaysPlay = holidays * 2 / 3;
        double playedDays = weekendsInSofia + holidaysPlay + weekends;

        if ("leap".equals(year)) {
            holidaysPlay = playedDays + playedDays * 0.15;
            System.out.printf("%.0f",Math.floor(holidaysPlay));
        } else if ("normal".equalsIgnoreCase(year)) {
            System.out.printf("%.0f", Math.floor(playedDays));
        }
    }
}
