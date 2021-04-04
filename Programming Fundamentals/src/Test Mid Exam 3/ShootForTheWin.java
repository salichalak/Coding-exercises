package P18_MidExam3;

import java.util.Arrays;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] targets = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input = scanner.nextLine();
        int counter = 0;

        while (!input.equals("End")) {
            int indexTarget = Integer.parseInt(input);

            if (indexTarget >= 0 && indexTarget < targets.length) {
                for (int i = 0; i < targets.length; i++) {
                    int temp = targets[indexTarget];

                    if (targets[i] != -1 && i != indexTarget) {
                        if (targets[i] > temp) {
                            targets[i] -= temp;

                        } else if (targets[i] <= temp) {
                            targets[i] += temp;
                        }
                    }
                }

                targets[indexTarget] = -1;
                counter++;
            }
            input = scanner.nextLine();
        }

        System.out.printf("Shot targets: %d -> ", counter);
        for (int target : targets) {
            System.out.print(target + " ");
        }
    }
}