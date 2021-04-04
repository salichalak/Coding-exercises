package WhileLoopLab;

import java.util.Scanner;

public class ExamPreparation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxPoorGrades = Integer.parseInt(scanner.nextLine());
        String task = scanner.nextLine();

        int poorGradesCounter = 0;
        int sumGrades = 0;
        int taskCounter = 0;
        String lastTask = "";

        while (!task.equals("Enough")) {

            int grade = Integer.parseInt(scanner.nextLine());
            sumGrades += grade;
            taskCounter++;

            if (grade <= 4) {
                poorGradesCounter++;
            }
            if (poorGradesCounter == maxPoorGrades) {
                System.out.printf("You need a break, %d poor grades.", poorGradesCounter);
                break;
            }

            lastTask = task;
            task = scanner.nextLine();
        }
        if (task.equals("Enough")) {
            double average = sumGrades * 1.0 / taskCounter;
            System.out.printf("Average score: %.2f%n", average);
            System.out.printf("Number of problems: %d%n", taskCounter);
            System.out.printf("Last problem: %s", lastTask);
        }
    }
}