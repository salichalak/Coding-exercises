package P08_ArraysExercise;

import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int wagons = Integer.parseInt(scanner.nextLine());
        int[] peopleInWagons = new int[wagons];
        int sum = 0;

        for (int i = 0; i < wagons; i++) {
            peopleInWagons[i] = Integer.parseInt(scanner.nextLine());
            System.out.print(peopleInWagons[i] + " ");
            sum += peopleInWagons[i];
        }
        System.out.printf("%n%d", sum);
    }
}