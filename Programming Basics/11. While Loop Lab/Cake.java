package WhileLoopLab;

import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int width = Integer.parseInt(scanner.nextLine());
        int length = Integer.parseInt(scanner.nextLine());

        int wholeCake = width * length;
        int piecesOfCake = 0;

        while (piecesOfCake <= wholeCake) {
            String command = scanner.nextLine();
            if ("STOP".equals(command)) {
                System.out.printf("%d pieces are left.", wholeCake - piecesOfCake);
                break;
            } else {
                piecesOfCake += Integer.parseInt(command);
            }
            if (piecesOfCake > wholeCake) {
                System.out.printf("No more cake left! You need %d pieces more.", piecesOfCake - wholeCake);
                break;
            }
        }
    }
}
