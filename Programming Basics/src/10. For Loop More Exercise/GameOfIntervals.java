package ForLoopLab2;

import java.util.Scanner;

public class GameOfIntervals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int moves = Integer.parseInt(scanner.nextLine());

        int from0to9 = 0;
        int from10to19 = 0;
        int from20to29 = 0;
        int from30to39 = 0;
        int from40to50 = 0;
        int invalid = 0;
        double result = 0;

        for (int i = 1; i <= moves; i++) {
            Double num = Double.parseDouble(scanner.nextLine());

            if (num >= 0 && num <= 50) {
                if (num < 10) {
                    num *= 0.2;
                    from0to9++;
                } else if (num < 20) {
                    num *= 0.3;
                    from10to19++;
                } else if (num < 30) {
                    num *= 0.4;
                    from20to29++;
                } else if (num < 40) {
                    num = 50.0;
                    from30to39++;
                } else {
                    num = 100.0;
                    from40to50++;
                }
                result += num;
            } else {
                result /= 2;
                invalid++;
            }
        }
        System.out.printf("%.2f%n", result);
        System.out.printf("From 0 to 9: %.2f%%%n", (from0to9 * 1.0 / moves * 100));
        System.out.printf("From 10 to 19: %.2f%%%n", (from10to19 * 1.0 / moves * 100));
        System.out.printf("From 20 to 29: %.2f%%%n", (from20to29 * 1.0 / moves * 100));
        System.out.printf("From 30 to 39: %.2f%%%n", (from30to39 * 1.0 / moves * 100));
        System.out.printf("From 40 to 50: %.2f%%%n", (from40to50 * 1.0 / moves * 100));
        System.out.printf("Invalid numbers: %.2f%%", (invalid * 1.0 / moves * 100));
    }
}
