package P10_MethodsLab;

import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int repeats = Integer.parseInt(scanner.nextLine());
        getRepeatedInput(input, repeats);
    }

    private static void getRepeatedInput(String input, int repeats) {
        StringBuilder text = new StringBuilder();
        for (int i = 0; i < repeats; i++) {
            text.append(input);
        }
        System.out.println(text.toString());
    }
}