package ConditionalStatementsLab;

import java.util.Scanner;

public class SwimmingWorldRecord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double record = Double.parseDouble(scanner.nextLine());
        double distance = Double.parseDouble(scanner.nextLine());
        double timeForOneMeter = Double.parseDouble(scanner.nextLine());

        double lag = Math.floor(distance / 15) * 12.5;
        double totalTime = distance * timeForOneMeter + lag;

        if (totalTime >=  record) {
            System.out.printf("No, he failed! He was %.2f seconds slower.", totalTime - record);
        } else if (totalTime < record) {
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.", totalTime);
        }
    }
}
