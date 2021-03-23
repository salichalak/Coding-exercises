package ConditionalStatementsLab;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double income = Double.parseDouble(scanner.nextLine());
        double averageGrade = Double.parseDouble(scanner.nextLine());
        double minimumWage = Double.parseDouble(scanner.nextLine());

        double socialScholarship = 0.0;
        double excellentScholarship = 0.0;

        if (income <= minimumWage && averageGrade >= 4.5) {
            socialScholarship = Math.floor(minimumWage * 0.35);
        }

        if (averageGrade >= 5.5) {
            excellentScholarship = Math.floor(averageGrade * 25);
        }

        if (socialScholarship > excellentScholarship) {
            System.out.printf("You get a Social scholarship %.0f BGN",socialScholarship);
        } else if (socialScholarship < excellentScholarship) {
            System.out.printf("You get a scholarship for excellent results %.0f BGN",excellentScholarship);
        } else {
            System.out.println("You cannot get a scholarship!");
        }
    }
}
