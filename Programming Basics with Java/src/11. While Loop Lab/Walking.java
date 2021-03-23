package WhileLoopLab;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goal = 10000;
        int totalSteps = 0;
        String command = scanner.nextLine();

        while (!command.equals("Going home")) {
            int steps = Integer.parseInt(command);
            totalSteps += steps;
            if (totalSteps >= 10000) {
                System.out.printf("Goal reached! Good job!%n %d steps over the goal!", totalSteps - 10000);
                break;
            }
            command = scanner.nextLine();
        }
        if (command.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scanner.nextLine());
            totalSteps += stepsToHome;
            if (totalSteps >= 10000) {
                System.out.printf("Goal reached! Good job!%n %d steps over the goal!", totalSteps - 10000);
            } else {
                System.out.printf("%d more steps to reach goal.", goal - totalSteps);
            }
        }
    }
}
