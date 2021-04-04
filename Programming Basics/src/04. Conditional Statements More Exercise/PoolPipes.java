package ConditionalStatementsLab2;

import java.util.Scanner;

public class PoolPipes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int v = Integer.parseInt(scanner.nextLine());
        int p1 = Integer.parseInt(scanner.nextLine());
        int p2 = Integer.parseInt(scanner.nextLine());
        double h = Double.parseDouble(scanner.nextLine());

        double p1Litres = p1 * h;
        double p2Litres = p2 * h;
        double totalLitres = p1Litres + p2Litres;

        double poolFull = (totalLitres / v) * 100.0;
        double p1Percent = (p1Litres / totalLitres) * 100.0;
        double p2Percent = (p2Litres / totalLitres) * 100.0;
        double excessWater = totalLitres - v;

        if (totalLitres <= v) {
            System.out.printf("The pool is %.2f%% full. Pipe 1: %.2f%%. Pipe 2: %.2f%%.", poolFull, p1Percent, p2Percent);
        } else {
            System.out.printf("For %.2f hours the pool overflows with %.2f liters", h, totalLitres - v);
        }
    }
}
