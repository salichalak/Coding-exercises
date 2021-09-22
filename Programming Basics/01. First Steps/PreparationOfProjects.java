package FirstSteps;

import java.util.Scanner;

public class PreparationOfProjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String architectName = scanner.nextLine();
        int numberOfProjects = Integer.parseInt(scanner.nextLine());
        int neededHours = numberOfProjects * 3;

        System.out.printf("The architect %s will need %d hours to complete %d project/s.",
                architectName, neededHours, numberOfProjects);
    }
}
