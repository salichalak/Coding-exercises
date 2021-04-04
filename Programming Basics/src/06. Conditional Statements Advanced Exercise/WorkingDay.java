package ConditionalStatementsAdvanced;

import java.util.Scanner;

public class WorkingDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String day = scanner.nextLine();

        if ("Monday".equals(day) || "Tuesday".equals(day) || "Wednesday".equals(day)
                || "Thursday".equals(day) || "Friday".equals(day)) {
            System.out.println("Working day");
        } else if ("Saturday".equals(day) || "Sunday".equals(day)) {
            System.out.println("Weekend");
        } else {
            System.out.println("Error");
        }
    }
}
