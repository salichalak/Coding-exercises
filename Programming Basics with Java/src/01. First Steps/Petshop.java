package FirstSteps;

import java.util.Scanner;

public class Petshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dogsCount = Integer.parseInt(scanner.nextLine());
        int otherAnimalsCount = Integer.parseInt(scanner.nextLine());

        double totalSumDog = dogsCount * 2.50;
        double totalSumOtherAnimals = otherAnimalsCount * 4;
        double totalSum = totalSumDog + totalSumOtherAnimals;
        System.out.println(totalSum + " " + "lv");
    }
}
