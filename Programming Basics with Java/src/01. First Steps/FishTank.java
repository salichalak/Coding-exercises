package FirstSteps;

import java.util.Scanner;

public class FishTank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lengthCm = Integer.parseInt(scanner.nextLine());
        int widthCm = Integer.parseInt(scanner.nextLine());
        int heightCm = Integer.parseInt(scanner.nextLine());
        double percent = Double.parseDouble(scanner.nextLine());

        double volume = lengthCm * widthCm * heightCm;
        double totalLitres = volume * 0.001;
        double percents = percent * 0.01;
        double neededLitres = totalLitres * (1 - percents);

        System.out.printf("%.2f", neededLitres);
    }
}