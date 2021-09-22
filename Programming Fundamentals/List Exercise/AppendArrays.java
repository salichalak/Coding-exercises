package P14_ListsExercise;

import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] arrays = scanner.nextLine().split("\\|");

        StringBuilder result = new StringBuilder();

        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] currentArr = arrays[i].split("\\s+");

            for (int j = 0; j < currentArr.length; j++) {
                if (!currentArr[j].equals("")) {
                    result.append(currentArr[j]).append(" ");
                }
            }

        }

        System.out.println(result.toString().trim());
    }
}