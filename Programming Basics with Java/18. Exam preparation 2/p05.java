package Test;

import java.util.Scanner;

public class p05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int soldGames = Integer.parseInt(scanner.nextLine());
        int game1 = 0;
        int game2 = 0;
        int game3 = 0;
        int otherGames = 0;

        for (int i = 0; i < soldGames; i++) {
            String game = scanner.nextLine();
            if ("Hearthstone".equals(game)) {
                game1++;
            } else if ("Fornite".equals(game)) {
                game2++;
            } else if ("Overwatch".equals(game)) {
                game3++;
            } else {
                otherGames++;
            }
        }
        double game1Percent = 1.0 * game1 / soldGames * 100;
        double game2Percent = 1.0 * game2 / soldGames * 100;
        double game3Percent = 1.0 * game3 / soldGames * 100;
        double otherGamesPercent = 1.0 * otherGames / soldGames * 100;

        System.out.printf("Hearthstone - %.2f%%%n", game1Percent);
        System.out.printf("Fornite - %.2f%%%n", game2Percent);
        System.out.printf("Overwatch - %.2f%%%n", game3Percent);
        System.out.printf("Others - %.2f%%%n", otherGamesPercent);
    }
}