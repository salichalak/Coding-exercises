package NestedLoopsLab;

import java.util.Scanner;

public class SpecialNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= 9; i++) {
            for (int o = 1; o <= 9; o++) {
                for (int p = 1; p <= 9; p++) {
                    for (int a = 1; a <= 9; a++) {

                        if (N % i == 0 && N % o == 0 && N % p == 0 && N % a == 0) {

                            System.out.printf("%d%d%d%d ", i, o, p, a);
                        }
                    }
                }
            }
        }
    }
}
