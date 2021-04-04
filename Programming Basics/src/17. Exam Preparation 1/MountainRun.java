package Exam28and29March;

import java.util.Scanner;

public class MountainRun {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeFor1meter = Double.parseDouble(scanner.nextLine());

        double totalSeconds = distance * timeFor1meter;
        double lag = Math.floor(distance / 50) * 30;
        double timePlusLag = totalSeconds + lag;

        if (timePlusLag < record) {
            System.out.printf("Yes! The new record is %.2f seconds.", timePlusLag);
        } else {
            System.out.printf("No! He was %.2f seconds slower.", Math.abs(timePlusLag - record));
        }
    }
}