package ConditionalStatementsLab2;

import java.util.Scanner;

public class SleepingTom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int daysOff = Integer.parseInt(scanner.nextLine());

        int daysOffPlay = daysOff * 127;
        int workdayPlay = (365 - daysOff) * 63;
        int totalPlay = daysOffPlay + workdayPlay;

        if (totalPlay < 30000) {
            int timeLeft = 30000 - totalPlay;
            int hours = timeLeft / 60;
            int minutes = timeLeft % 60;
            System.out.println("Tom sleeps well");
            System.out.printf("%d hours and %d minutes less for play", hours, minutes);
        } else {
            int timeLeft = totalPlay - 30000;
            int hours = timeLeft / 60;
            int minutes = timeLeft % 60;
            System.out.println("Tom will run away");
            System.out.printf("%d hours and %d minutes more for play", hours, minutes);
        }
    }
}
