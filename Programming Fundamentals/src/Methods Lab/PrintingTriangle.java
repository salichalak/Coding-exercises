package P10_MethodsLab;

import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        PrintTriangle(n);
    }

    static void PrintLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void PrintTriangle(int n) {
        for (int line = 1; line <= n; line++) {
            PrintLine(1, line);
        }

        for (int line = n - 1; line >= 1; line--) {
            PrintLine(1, line);
        }
    }
}