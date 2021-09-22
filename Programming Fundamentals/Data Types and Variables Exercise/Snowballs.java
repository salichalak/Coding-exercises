package P05_DataTypesAndVariablesExercise;

import java.util.Scanner;

public class Snowballs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int snowballsCount = Integer.parseInt(scanner.nextLine());

        int maxSnow = Integer.MIN_VALUE;
        int maxTime = Integer.MIN_VALUE;
        int maxQuality = Integer.MIN_VALUE;
        double maxValue = Double.MIN_VALUE;

        for (int i = 0; i < snowballsCount; i++) {
            int snowballSnow = Integer.parseInt(scanner.nextLine());
            int snowballTime = Integer.parseInt(scanner.nextLine());
            int snowballQuality = Integer.parseInt(scanner.nextLine());

            double snowballValue = Math.pow((1.0 * snowballSnow / snowballTime), snowballQuality);

            if (snowballValue > maxValue) {
                maxValue = snowballValue;
                maxSnow = snowballSnow;
                maxTime = snowballTime;
                maxQuality = snowballQuality;
            }
        }
        System.out.printf("%d : %d = %.0f (%d)", maxSnow, maxTime, maxValue, maxQuality);
    }
}