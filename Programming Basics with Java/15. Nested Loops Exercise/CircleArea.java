package FirstStepsLab;

import java.util.Scanner;

public class CircleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double r = Double.parseDouble(scanner.nextLine());

        double area = Math.PI * r * r;
        double perimeter = (Math.PI * r) * 2;

        System.out.printf("%.2f%n", area);
        System.out.printf("%.2f", perimeter);
    }
}
