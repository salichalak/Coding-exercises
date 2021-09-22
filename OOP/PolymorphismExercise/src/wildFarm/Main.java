package wildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Mammal> mammals = new ArrayList<>();

        String input;
        while (!"End".equals(input = scanner.nextLine())) {
            String[] animalData = input.split("\\s+");
            String[] foodData = scanner.nextLine().split("\\s+");

            Food food = getFoodTypeAndQuantity(foodData);
            Mammal animal = getMammal(animalData);

            animal.makeSound();
            animal.eat(food);
            mammals.add(animal);
        }

        for (Mammal mammal : mammals) {
            System.out.println(mammal);
        }
    }

    private static Mammal getMammal(String[] animalInfo) {
        String animalType = animalInfo[0];
        String name = animalInfo[1];
        double weight = Double.parseDouble(animalInfo[2]);
        String animalLivingRegion = animalInfo[3];

        Mammal animal = null;
        switch (animalType) {
            case "Cat":
                String breed = animalInfo[4];
                animal = new Cat(name, animalType, weight, animalLivingRegion, breed);
                break;
            case "Mouse":
                animal = new Mouse(name, animalType, weight, animalLivingRegion);
                break;
            case "Tiger":
                animal = new Tiger(name, animalType, weight, animalLivingRegion);
                break;
            case "Zebra":
                animal = new Zebra(name, animalType, weight, animalLivingRegion);
                break;
        }

        return animal;
    }

    private static Food getFoodTypeAndQuantity(String[] foodInfo) {
        Food food;
        if (foodInfo[0].equals("Vegetable")) {
            food = new Vegetable(Integer.parseInt(foodInfo[1]));
        } else {
            food = new Meat(Integer.parseInt(foodInfo[1]));
        }
        return food;
    }
}