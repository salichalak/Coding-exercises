package ConditionalStatementsLab;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        String input = scanner.nextLine();
        String output = scanner.nextLine();

        if (input.equals("mm")) {
            number = number / 1000;
        } else if (input.equals("cm")) {
            number = number / 100;
        } else if (input.equals("m")) {
            number = number;
        }

        if (output.equals("mm")) {
            number = number * 1000;
        } else if (output.equals("cm")) {
            number = number * 100;
        } else if (output.equals("m")) {
            number = number;
        }

        System.out.printf("%.3f", number);
    }
}
