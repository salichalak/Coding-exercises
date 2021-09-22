package P12_MethodsMoreExercise;

import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        findDataType(scanner);
    }

    private static void findDataType(Scanner scanner) {
        String type = scanner.nextLine();
        String input = scanner.nextLine();

        switch (type) {
            case "int":
                int number = Integer.parseInt(input) * 2;
                System.out.println(number);
                break;
            case "real":
                double realNumber = Double.parseDouble(input) * 1.5;
                System.out.printf("%.2f", realNumber);
                break;
            case "string":
                System.out.printf("$%s$", input);
                break;
        }
    }
}