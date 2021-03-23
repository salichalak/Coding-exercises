package ForLoopLab2;

import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int students = Integer.parseInt(scanner.nextLine());

        double averageGrade = 0.0;
        int topStudent = 0;
        int between4and5 = 0;
        int between3and4 = 0;
        int fail = 0;

        for (int i = 1; i <= students; i++) {
            double grade = Double.parseDouble(scanner.nextLine());
            averageGrade += grade;
            if (grade >= 5) {
                topStudent++;
            }
            if (grade >= 4 && grade <= 4.99) {
                between4and5++;
            }
            if (grade >= 3 && grade <= 3.99) {
                between3and4++;
            }
            if (grade < 3) {
                fail++;
            }
        }
        System.out.printf("Top students: %.2f%%%n", (1.0 * topStudent / students) * 100);
        System.out.printf("Between 4.00 and 4.99: %.2f%%%n", (1.0 * between4and5 / students) * 100);
        System.out.printf("Between 3.00 and 3.99: %.2f%%%n", (1.0 * between3and4 / students) * 100);
        System.out.printf("Fail: %.2f%%%n", (1.0 * fail / students) * 100);
        System.out.printf("Average: %.2f%n", averageGrade / students);
    }
}
