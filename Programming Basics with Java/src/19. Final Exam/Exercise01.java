package Pb_Exam_Online;

import java.util.Scanner;

public class Exercise01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double averageSpeed = Double.parseDouble(scanner.nextLine());
        double litresFor100Km = Double.parseDouble(scanner.nextLine());

        double totalDistance = 768800;
        double timeForTravel = Math.ceil(totalDistance / averageSpeed);
        double totalTime = timeForTravel + 3;
        double totalFuel = (litresFor100Km * totalDistance) / 100;

        System.out.printf("%.0f%n", totalTime);
        System.out.printf("%.0f%n", totalFuel);

    }
}
