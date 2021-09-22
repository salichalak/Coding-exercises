package SetsAndMapsAdvancedLab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LinkedHashSet<String> parkingLot = new LinkedHashSet<>();
        String input = scanner.nextLine();

        while (!input.equals("END")) {
            String[] tokens = input.split(",\\s+");
            String command = tokens[0];
            String currentCar = tokens[1];

            if (command.equals("IN")) {
                parkingLot.add(currentCar);
            } else if (command.equals("OUT")) {
                parkingLot.remove(currentCar);
            }

            input = scanner.nextLine();
        }

        if (parkingLot.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String car : parkingLot) {
                System.out.println(car);
            }
        }
    }
}