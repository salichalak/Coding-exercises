package P10_MethodsLab;

import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double number = Double.parseDouble(scanner.nextLine());
        int power = Integer.parseInt(scanner.nextLine());

        double result = numberRaisedToPower(number, power);
        System.out.println(new DecimalFormat("0.####").format(numberRaisedToPower(number, power)));
    }

    private static double numberRaisedToPower(double number, int power) {
        return Math.pow(number, power);
    }
}