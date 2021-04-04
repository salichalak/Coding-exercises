package P05_DataTypesAndVariablesExercise;

import java.util.Scanner;

public class BeerKegs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());
        String bestKegModel = "";
        double bestKegVolume = Double.MIN_VALUE;

        for (int keg = 0; keg < count; keg++) {
            String model = scanner.nextLine();
            double radius = Double.parseDouble(scanner.nextLine());
            int height = Integer.parseInt(scanner.nextLine());

            double volume = Math.PI * Math.pow(radius, 2) * height;

            if (volume > bestKegVolume) {
                bestKegVolume = volume;
                bestKegModel = model;
            }
        }
        System.out.println(bestKegModel);
    }
}