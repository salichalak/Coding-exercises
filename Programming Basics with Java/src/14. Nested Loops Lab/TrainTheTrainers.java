package NestedLoopsLab;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jury = Integer.parseInt(scanner.nextLine());
        String presentation = scanner.nextLine();
        double sumCurrentGrades = 0.0;
        double averageGrade = 0.0;
        double sumTotalGrades = 0.0;
        int counter = 0;

        while (!presentation.equals("Finish")) {
            sumCurrentGrades = 0;
            for (int gradeCounter = 1; gradeCounter <= jury; gradeCounter++) {
                double grade = Double.parseDouble(scanner.nextLine());
                sumTotalGrades += grade;
                sumCurrentGrades += grade;
                counter++;

                if (gradeCounter == jury) {
                    averageGrade = sumCurrentGrades / jury;
                    break;
                }
            }
            System.out.printf("%s - %.2f.%n", presentation, averageGrade);
            presentation = scanner.nextLine();
        }
        double totalGrade = sumTotalGrades / counter;
        System.out.printf("Student's final assessment is %.2f.", totalGrade);
    }
}
