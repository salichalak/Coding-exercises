package Exam28and29March;

import java.util.Scanner;

public class SuitcasesLoad {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double capacity = Double.parseDouble(scanner.nextLine());
        String suitcase = scanner.nextLine();
        int counter = 0;

        while (!suitcase.equals("End")) {
            if ((counter + 1) % 3 == 0) {
                double suitcase3 = Double.parseDouble(suitcase);
                suitcase3 = suitcase3 * 1.1;
                capacity -= suitcase3;
            } else {
                capacity -= Double.parseDouble(suitcase);
            }
            if (capacity < 0) {
                break;
            }
            counter++;
            suitcase = scanner.nextLine();
        }
        if (capacity < 0) {
            System.out.println("No more space!");
            System.out.printf("Statistic: %d suitcases loaded.", counter);
        } else {
            System.out.println("Congratulations! All suitcases are loaded!");
            System.out.printf("Statistic: %d suitcases loaded.", counter);
        }
    }
}
