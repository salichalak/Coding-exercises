package FirstStepsLab;

import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hallLength = Double.parseDouble(scanner.nextLine());
        double hallWidth = Double.parseDouble(scanner.nextLine());
        double wardrobeSide = Double.parseDouble(scanner.nextLine());

        double hallArea = (hallLength * 100) * (hallWidth * 100);
        double wardrobeArea = (wardrobeSide * 100) * (wardrobeSide * 100);
        double benchArea = hallArea / 10;

        double freeSpace = hallArea - wardrobeArea - benchArea;
        double dancers = Math.floor(freeSpace / (40 + 7000));
        System.out.println(dancers);
    }
}
