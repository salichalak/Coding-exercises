package FirstStepsLab;

import java.util.Scanner;

public class BookList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int pages = Integer.parseInt(scanner.nextLine());
        int pagesForHour = Integer.parseInt(scanner.nextLine());
        int neededDays = Integer.parseInt(scanner.nextLine());

        int totalHoursForOneBook = pages / pagesForHour;
        int totalHoursNeeded = totalHoursForOneBook / neededDays;

        System.out.println(totalHoursNeeded);
    }
}
