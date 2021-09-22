package Students;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] studentsData = scanner.nextLine().split("\\s+");
            String firstName = studentsData[0];
            String lastName = studentsData[1];
            Double grade = Double.parseDouble(studentsData[2]);

            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        List<Student> sortedList = students.stream().sorted(Comparator.comparing(Student::getGrade).reversed()).collect(Collectors.toList());

        for (Student student : sortedList) {
            System.out.print(student);
        }
    }
}