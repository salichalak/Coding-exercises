package WhileLoop;

import java.util.Scanner;

public class GraduationPart2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String name = scanner.nextLine();

        int failCounter = 0;
        int clazz = 0;
        double totalGrades = 0;

        while (clazz < 12) {
            double mark = Double.parseDouble(scanner.nextLine());

            if (mark >= 4) {
                totalGrades += mark;
                clazz++;
            } else {
                failCounter++;
                if (failCounter >= 2) {
                    clazz++;
                    System.out.printf("%s has been excluded at %d grade", name, clazz);
                    break;
                }
            }
        }
        if (failCounter < 2) {
            System.out.printf("%s graduated. Average grade: %.2f", name, totalGrades / clazz);
        }
    }
}