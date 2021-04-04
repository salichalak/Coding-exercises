package P21_MapsExercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Integer> resourcesQuantity = new LinkedHashMap<>();
        String resource = scanner.nextLine();

        while (!resource.equals("stop")) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!resourcesQuantity.containsKey(resource)) {
                resourcesQuantity.put(resource, quantity);
            } else {
                resourcesQuantity.put(resource, resourcesQuantity.get(resource) + quantity);
            }

            resource = scanner.nextLine();
        }

        resourcesQuantity.forEach((k, v) -> System.out.println(k + " -> " + v));
    }
}