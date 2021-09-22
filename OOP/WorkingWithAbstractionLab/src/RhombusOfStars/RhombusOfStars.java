package RhombusOfStars;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        System.out.println(getRhombusOfStars(n, true));
        System.out.println(getRhombusOfStars(n, false));
    }

    public static String getRhombusOfStars(int n, boolean isUpwardsOriented) {
        StringBuilder output = new StringBuilder();

        for (int r = 1; r <= n; r++) {
            int spacesCount = isUpwardsOriented ? n - r : r;
            int starsCount = isUpwardsOriented ? r : n - r;

            output.append(repeatString(spacesCount, " "));
            output.append(repeatString(starsCount, "* "));

            if (r != n) {
                output.append(System.lineSeparator());
            }
        }

        return output.toString();
    }

    public static String repeatString(int count, String toRepeat) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < count; i++) {
            output.append(toRepeat);
        }

        return output.toString();
    }
}