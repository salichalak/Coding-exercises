package P19_MidExam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Exercise03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> priceRating = Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).collect(Collectors.toList());

        int entryPoint = Integer.parseInt(scanner.nextLine());
        String itemType = scanner.nextLine();

        int leftSum = 0;
        int rightSum = 0;

        if (itemType.equals("cheap")) {
            for (int left = 0; left < entryPoint; left++) {
                int currentItem = priceRating.get(left);
                if (currentItem < priceRating.get(entryPoint)) {
                    leftSum += currentItem;
                }
            }

            for (int right = entryPoint + 1; right < priceRating.size(); right++) {
                int currentItem = priceRating.get(right);
                if (currentItem < priceRating.get(entryPoint)) {
                    rightSum += currentItem;
                }
            }
        }

        if (itemType.equals("expensive")) {
            for (int left = 0; left < entryPoint; left++) {
                int currentItem = priceRating.get(left);
                if (currentItem >= priceRating.get(entryPoint)) {
                    leftSum += currentItem;
                }
            }

            for (int right = entryPoint + 1; right < priceRating.size(); right++) {
                int currentItem = priceRating.get(right);
                if (currentItem >= priceRating.get(entryPoint)) {
                    rightSum += currentItem;
                }
            }
        }

        if (rightSum > leftSum) {
            System.out.printf("Right - %d", rightSum);
        } else {
            System.out.printf("Left - %d", leftSum);
        }
    }
}