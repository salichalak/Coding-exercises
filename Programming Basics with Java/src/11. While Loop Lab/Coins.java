package WhileLoopLab;

import java.util.Scanner;

public class Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double change = Double.parseDouble(scanner.nextLine());
        int coin = 0;
        change = Math.round(change * 100);

        while (change > 0) {

            if (change >= 200) {
                coin++;
                change = change - 200;
            } else if (change >= 100) {
                coin++;
                change = change - 100;
            } else if (change >= 50) {
                coin++;
                change = change - 50;
            } else if (change >= 20) {
                coin++;
                change = change - 20;
            } else if (change >= 10) {
                coin++;
                change = change - 10;
            } else if (change >= 5) {
                coin++;
                change = change - 5;
            } else if (change >= 2) {
                coin++;
                change = change - 2;
            } else if (change >= 1) {
                coin++;
                change = change - 1;
            }
        }
        System.out.println(coin);
    }
}
