package P30_ExamPreparation5;

import java.util.*;

public class NeedForSpeed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> carsMileage = new TreeMap<>();
        Map<String, Integer> carsFuel = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("\\|");
            carsMileage.putIfAbsent(line[0], Integer.parseInt(line[1]));
            carsFuel.putIfAbsent(line[0], Integer.parseInt(line[2]));
        }

        String input = scanner.nextLine();

        while (!input.equals("Stop")) {
            String[] inputSplit = input.split(" : ");
            String command = inputSplit[0];

            if (command.equals("Drive")) {
                String car = inputSplit[1];
                int distance = Integer.parseInt(inputSplit[2]);
                int fuel = Integer.parseInt(inputSplit[3]);

                if (carsFuel.get(car) < fuel) {
                    System.out.println("Not enough fuel to make that ride");
                } else {
                    carsMileage.put(car, carsMileage.get(car) + distance);
                    carsFuel.put(car, carsFuel.get(car) - fuel);
                    System.out.printf("%s driven for %d kilometers. %d liters of fuel consumed.%n", car, distance, fuel);
                    if (carsMileage.get(car) >= 100000) {
                        carsMileage.remove(car);
                        carsFuel.remove(car);
                        System.out.println("Time to sell the " + car + "!");
                    }
                }

            } else if (command.equals("Refuel")) {
                String car = inputSplit[1];
                int fuel = Integer.parseInt(inputSplit[2]);

                if (carsFuel.get(car) + fuel > 75) {
                    System.out.printf("%s refueled with %d liters%n", car, 75 - carsFuel.get(car));
                    carsFuel.put(car, 75);

                } else {
                    carsFuel.put(car, carsFuel.get(car) + fuel);
                    System.out.printf("%s refueled with %d liters%n", car, fuel);
                }

            } else if (command.equals("Revert")) {
                String car = inputSplit[1];
                int kilometers = Integer.parseInt(inputSplit[2]);
                carsMileage.put(car, carsMileage.get(car) - kilometers);
                if (carsMileage.get(car) > 10000) {
                    System.out.printf("%s mileage decreased by %d kilometers%n", car, kilometers);
                } else {
                    carsMileage.put(car, 10000);
                }

            }

            input = scanner.nextLine();
        }

        carsMileage.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(car -> {
                    System.out.printf("%s -> Mileage: %d kms, Fuel in the tank: %d lt.%n",
                            car.getKey(), car.getValue(), carsFuel.get(car.getKey()));
                });
    }
}