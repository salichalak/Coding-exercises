package ConditionalStatementsLab;

import java.util.Scanner;

public class TimePlus15Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());
        int totalMinutes = minutes + 15;

        if (totalMinutes > 59) {
            hours++;
            totalMinutes = totalMinutes - 60;
        }

        if (hours > 23) {
            hours = 0;
        }

        if (totalMinutes < 10) {
            System.out.println(hours + ":0" + totalMinutes);
        } else {
            System.out.println(hours + ":" + totalMinutes);
        }
    }
}
