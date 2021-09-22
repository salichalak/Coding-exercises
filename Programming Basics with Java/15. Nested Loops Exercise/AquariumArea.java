package FirstStepsLab;

import java.util.Scanner;

public class AquariumArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int width = Integer.parseInt(scanner.nextLine());
        int height = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = length * width * height;
        double volumeInLiters = volume * 0.001;
        double neededLiters = volumeInLiters - volumeInLiters  * 0.17;

        System.out.printf("%.2f", neededLiters);
    }
}
