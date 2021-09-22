package ConditionalStatementsLab2;

import java.util.Scanner;

public class Firm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int neededHours = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());
        int workersOvertime = Integer.parseInt(scanner.nextLine());

        double workingDays = days * 0.90;
        double workingHours = workingDays * 8;
        double totalWorkersOvertime = workersOvertime * (2 * days);
        double totalHours = Math.floor(totalWorkersOvertime + workingHours);

        if (totalHours >= neededHours) {
            double hoursLeft = totalHours - neededHours;
            System.out.printf("Yes!%.0f hours left.", hoursLeft);
        } else if (totalHours < neededHours) {
            double hoursNeeded = neededHours - totalHours;
            System.out.printf("Not enough time!%.0f hours needed.", hoursNeeded);
        }
    }
}
