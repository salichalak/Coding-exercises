package ConditionalStatementsAdvancedLab;

import java.util.Scanner;

public class ExamTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int examHour = Integer.parseInt(scanner.nextLine());
        int examMinute = Integer.parseInt(scanner.nextLine());
        int arrivalHour = Integer.parseInt(scanner.nextLine());
        int arrivalMinute = Integer.parseInt(scanner.nextLine());

        int examTime = examHour * 60 + examMinute;
        int arrivalTime = arrivalHour * 60 + arrivalMinute;

        if (examTime == arrivalTime || (examTime > arrivalTime && examTime - arrivalTime <= 30)) {
            System.out.println("On time");
        }
        if (examTime > arrivalTime && examTime - arrivalTime > 30) {
            System.out.println("Early");
        }
        if (arrivalTime > examTime) {
            System.out.println("Late");
        }
        if (Math.abs(arrivalTime - examTime) != 0) {
            int hours = Math.abs(arrivalTime - examTime) / 60;
            int mins = Math.abs(arrivalTime - examTime) % 60;
            if (hours >= 1) {
                if (mins < 10) {
                    System.out.print(hours + ":0" + mins + " hours");
                } else {
                    System.out.print(hours + ":" + mins + " hours");
                }
            } else {
                System.out.print(mins + " minutes");
            }
            if ((arrivalTime - examTime) < 0) {
                System.out.println(" before the start");
            } else {
                System.out.println(" after the start");
            }
        }
    }
}


