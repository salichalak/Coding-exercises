package P04_DataTypesAndVariablesLab;

import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < 3; i++) {
            String input = scanner.nextLine();
            output.append(input);
        }
        System.out.println(output);
    }
}