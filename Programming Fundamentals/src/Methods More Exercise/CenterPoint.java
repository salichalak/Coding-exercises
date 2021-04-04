package P12_MethodsMoreExercise;

import java.util.Scanner;

public class CenterPoint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int y1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int y2 = Integer.parseInt(scanner.nextLine());
        System.out.printf("(%s)", closestToCenter(x1, y1, x2, y2));
    }

    private static String closestToCenter(int x1, int y1, int x2, int y2) {
        String closest = "";
        int firstPoint = Math.abs(x1) + Math.abs(y1);
        int secondPoint = Math.abs(x2) + Math.abs(y2);

        if (firstPoint < secondPoint) {
            closest = x1 + ", " + y1;
        } else if (firstPoint > secondPoint) {
            closest = x2 + ", " + y2;
        } else {
            closest = x1 + ", " + y1;
        }

        return closest;
    }
}