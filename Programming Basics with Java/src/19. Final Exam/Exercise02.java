package Pb_Exam_Online;

import java.util.Scanner;

public class Exercise02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int processorsOrdered = Integer.parseInt(scanner.nextLine());
        int workers = Integer.parseInt(scanner.nextLine());
        int days = Integer.parseInt(scanner.nextLine());

        double totalHours = days * workers * 8;
        double processorsProduced = Math.floor(totalHours / 3);

        if (processorsProduced < processorsOrdered) {
            double losses = (processorsOrdered - processorsProduced) * 110.10;
            System.out.printf("Losses: -> %.2f BGN", losses);
        } else if (processorsProduced >= processorsOrdered){
            double profit = (processorsProduced - processorsOrdered) * 110.10;
            System.out.printf("Profit: -> %.2f BGN", profit);
        }
    }
}
