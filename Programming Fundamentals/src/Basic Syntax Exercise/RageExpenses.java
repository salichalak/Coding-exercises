package P02_BasicSyntaxExercise;

import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());

        int headsetCount = lostGames / 2;
        double headsetSum = headsetCount * headsetPrice;

        int mouseCount = lostGames / 3;
        double mouseSum = mouseCount * mousePrice;

        int keyboardCount = lostGames / 6;
        double keyboardSum = keyboardCount * keyboardPrice;

        int displayCount = lostGames / 12;
        double displaySum = displayCount * displayPrice;

        double expenses = headsetSum + mouseSum + keyboardSum + displaySum;
        System.out.printf("Rage expenses: %.2f lv.", expenses);
    }
}