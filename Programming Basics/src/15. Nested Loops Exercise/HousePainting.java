package FirstStepsLab;

import java.util.Scanner;

public class HousePainting {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double houseHeight = Double.parseDouble(scanner.nextLine());
        double sideWallLength = Double.parseDouble(scanner.nextLine());
        double roofTriangleHeight = Double.parseDouble(scanner.nextLine());

        double areaDoor = 2 * 1.2;
        double areaWindows = 2 * (1.5 * 1.5);
        double areaFrontWalls = 2 * (houseHeight * houseHeight) - areaDoor;
        double sideWalls = 2 * (houseHeight * sideWallLength) - areaWindows;
        double wallTotalArea = areaFrontWalls + sideWalls;

        double greenPaint = wallTotalArea / 3.4;

        double totalAreaRoof = 2 * (houseHeight * sideWallLength) + (2 * (houseHeight * roofTriangleHeight / 2));
        double redPaint = totalAreaRoof / 4.3;

        System.out.printf("%.2f%n", greenPaint);
        System.out.printf("%.2f", redPaint);
    }
}
