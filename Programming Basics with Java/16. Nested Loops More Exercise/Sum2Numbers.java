package NestedLoops;

import java.util.Scanner;

public class Sum2Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int start = Integer.parseInt(scanner.nextLine());
        int end = Integer.parseInt(scanner.nextLine());
        int magicNum = Integer.parseInt(scanner.nextLine());

        int combinations = 0;

        for (int x1 = start; x1 <= end; x1++) {
            for (int x2 = start; x2 <= end; x2++) {
                combinations++;

                if (x1 + x2 == magicNum) {
                    System.out.printf("Combination N:%d (%d + %d = %d)%n", combinations, x1, x2, magicNum);
                    return;
                }
            }
        }
        System.out.printf("%d combinations - neither equals %d", combinations, magicNum);
    }
}
