package Test;

import java.util.Scanner;

public class p06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String winner = "";
        int bestPoints = 0;
        String name = scanner.nextLine();

        while (!"Stop".equals(name)) {
            int currentPoints = 0;
            for (int i = 0; i < name.length(); i++) {
                double number = Integer.parseInt(scanner.nextLine());
                if (number == name.charAt(i)) {
                    currentPoints += 10;
                } else {
                    currentPoints += 2;
                }
            }
            if (currentPoints >= bestPoints) {
                bestPoints = currentPoints;
                winner = name;
            }
            name = scanner.nextLine();
        }
        System.out.printf("The winner is %s with %d points!", winner, bestPoints);
    }
}
