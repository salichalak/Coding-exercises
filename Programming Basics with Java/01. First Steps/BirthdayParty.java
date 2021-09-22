package FirstSteps;

import java.util.Scanner;

public class BirthdayParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hallRent = Integer.parseInt(scanner.nextLine());

        double cake = hallRent * 0.20;
        double drinks = cake - (cake * 0.45);
        double animator = hallRent / 3;
        double totalSum = hallRent + cake + drinks + animator;

        System.out.println(totalSum);
    }
}