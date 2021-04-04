package P17_MidExam2;

import java.util.Scanner;

public class NationalCurt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int firstEmployee = Integer.parseInt(scanner.nextLine());
        int secondEmployee = Integer.parseInt(scanner.nextLine());
        int thirdEmployee = Integer.parseInt(scanner.nextLine());
        int people = Integer.parseInt(scanner.nextLine());

        int timeNeeded = 0;

        int totalEfficiencyPerHour = firstEmployee + secondEmployee + thirdEmployee;

        while (people > 0) {
            people -= totalEfficiencyPerHour;
            timeNeeded++;
            if (timeNeeded % 4 == 0) {
                timeNeeded++;
            }
        }
        System.out.printf("Time needed: %dh.", timeNeeded);
    }
}