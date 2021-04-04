package P04_DataTypesAndVariablesLab;

import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char character = scanner.nextLine().charAt(0);

        if (character < 97) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}