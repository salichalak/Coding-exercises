package P05_DataTypesAndVariablesExercise;

import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int power = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        byte exhaustionFactor = Byte.parseByte(scanner.nextLine());

        int pokedTargets = 0;
        double halfPower = power / 2.0;

        while (power >= distance) {
            pokedTargets++;
            power -= distance;

            if (power == halfPower) {
                if (exhaustionFactor > 0) {
                    power /= exhaustionFactor;
                }
            }
        }
        System.out.println(power);
        System.out.println(pokedTargets);
    }
}