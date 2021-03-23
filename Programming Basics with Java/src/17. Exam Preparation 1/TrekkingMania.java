package Exam28and29March;

import java.util.Scanner;

public class TrekkingMania {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int groups = Integer.parseInt(scanner.nextLine());

        int Musala = 0;
        int Montblanc = 0;
        int Kilimandjaro = 0;
        int K2 = 0;
        int Everest = 0;

        for (int i = 0; i < groups; i++) {
            int alpinist = Integer.parseInt(scanner.nextLine());
            if (alpinist <= 5) {
                Musala += alpinist;
            } else if (alpinist >= 6 && alpinist <= 12) {
                Montblanc += alpinist;
            } else if (alpinist >= 13 && alpinist <= 25) {
                Kilimandjaro += alpinist;
            } else if (alpinist >= 26 && alpinist <= 40) {
                K2 += alpinist;
            } else {
                Everest += alpinist;
            }
        }
        int allAlpinist = Musala + Montblanc + Kilimandjaro + K2 + Everest;
        double percentMusala = (1.0 * Musala / allAlpinist) * 100;
        double percentMontblanc = (1.0 * Montblanc / allAlpinist) * 100;
        double percentKilimandjaro = (1.0 * Kilimandjaro / allAlpinist) * 100;
        double percentK2 = (1.0 * K2 / allAlpinist) * 100;
        double percentEverest = (1.0 * Everest / allAlpinist) * 100;

        System.out.printf("%.2f%%%n", percentMusala);
        System.out.printf("%.2f%%%n", percentMontblanc);
        System.out.printf("%.2f%%%n", percentKilimandjaro);
        System.out.printf("%.2f%%%n", percentK2);
        System.out.printf("%.2f%%%n", percentEverest);
    }
}
