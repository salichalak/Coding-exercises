package ForLoopLab;

import java.util.Scanner;

public class OddEvenPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double EvenSum = 0.0;
        double OddSum = 0.0;
        double OddMin = 1000000000.0;
        double OddMax = -1000000000.0;
        double EvenMin = 1000000000.0;
        double EvenMax = -1000000000.0;

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= n; i++) {

            double num = Double.parseDouble(scanner.nextLine());

            if (i % 2 == 0) {
                EvenSum += num;

                if (num > EvenMax) {
                    EvenMax = num;
                }
                if (num < EvenMin) {
                    EvenMin = num;
                }
            } else {
                OddSum += num;

                if (num > OddMax) {
                    OddMax = num;
                }
                if (num < OddMin) {
                    OddMin = num;
                }
            }
        }
        if (n == 0) {
            System.out.println("OddSum=" + String.format("%.2f,", OddSum));
            System.out.println("OddMin=No,");
            System.out.println("OddMax=No,");
            System.out.println("EvenSum=" + String.format("%.2f,", EvenSum));
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        } else if ((EvenMin == 1000000000.0) || (EvenMax == -1000000000.0)) {
            System.out.println("OddSum=" + String.format("%.2f,", OddSum));
            System.out.println("OddMin=" + String.format("%.2f,", OddMin));
            System.out.println("OddMax=" + String.format("%.2f,", OddMax));
            System.out.println("EvenSum=" + String.format("%.2f,", EvenSum));
            System.out.println("EvenMin=No,");
            System.out.println("EvenMax=No");
        } else {
            System.out.println("OddSum=" + String.format("%.2f,", OddSum));
            System.out.println("OddMin=" + String.format("%.2f,", OddMin));
            System.out.println("OddMax=" + String.format("%.2f,", OddMax));
            System.out.println("EvenSum=" + String.format("%.2f,", EvenSum));
            System.out.println("EvenMin=" + String.format("%.2f,", EvenMin));
            System.out.println("EvenMax=" + String.format("%.2f", EvenMax));
        }
    }
}
