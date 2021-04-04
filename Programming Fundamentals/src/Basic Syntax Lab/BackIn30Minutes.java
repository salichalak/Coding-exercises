package P01_BasicSyntaxLab;

import java.util.Scanner;

public class BackIn30Minutes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hours = Integer.parseInt(scanner.nextLine());
        int minutes = Integer.parseInt(scanner.nextLine());

        int totalMinutes = minutes + 30;
        if (totalMinutes > 59) {
            totalMinutes -= 60;
            hours++;
        }
        if (hours > 23) {
            hours = 0;
        }
        System.out.printf("%d:%02d", hours, totalMinutes);
    }
}