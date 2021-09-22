package P16_MidExam1;

import java.util.Scanner;

public class BonusScoringSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());
        int lectures = Integer.parseInt(scanner.nextLine());
        int courseBonus = Integer.parseInt(scanner.nextLine());

        double highestBonus = 0;
        int maxAttendances = 0;

        for (int student = 0; student < students; student++) {
            int attendances = Integer.parseInt(scanner.nextLine());
            double currentBonus = (1.0 * attendances / lectures) * (5 + courseBonus);

            if (currentBonus > highestBonus) {
                highestBonus = currentBonus;
                maxAttendances = attendances;
            }
        }

        System.out.printf("Max Bonus: %d.%n", Math.round(highestBonus));
        System.out.printf("The student has attended %d lectures.", maxAttendances);
    }
}