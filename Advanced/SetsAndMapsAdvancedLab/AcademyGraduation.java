package SetsAndMapsAdvancedLab;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TreeMap<String, double[]> studentGrades = new TreeMap<>();
        int students = Integer.parseInt(scanner.nextLine());

        for (int student = 1; student <= students; student++) {
            String name = scanner.nextLine();
            double[] scores = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

            studentGrades.put(name, scores);
        }

        studentGrades.forEach((student, grades) -> {
            System.out.printf("%s is graduated with %f%n", student,
                    Arrays.stream(grades).average().orElse(0));
        });
    }
}