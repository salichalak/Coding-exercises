package FirstStepsLab;

import java.util.Scanner;

public class CelciusToFahreinheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double degrees = Double.parseDouble(scanner.nextLine());
        double fahrenheit = degrees * 1.8 + 32;

        System.out.printf("%.2f", fahrenheit);
    }
}
