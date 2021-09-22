package P14_ListsExercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PokemonDontGo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pokemon = Arrays.stream(scanner.nextLine()
                .split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());

        int sum = 0;

        while (!pokemon.isEmpty()) {
            int index = Integer.parseInt(scanner.nextLine());

            if (index >= 0 && index <= pokemon.size() - 1) {
                int element = pokemon.get(index);
                sum += element;
                pokemon.remove(index);
                changeListContent(pokemon, element);
            } else if (index < 0) {
                int element = pokemon.get(0);
                sum += element;
                pokemon.set(0, pokemon.get(pokemon.size() - 1));
                changeListContent(pokemon, element);
            } else {
                int element = pokemon.get(pokemon.size() - 1);
                sum += element;
                pokemon.set((pokemon.size() - 1), pokemon.get(0));
                changeListContent(pokemon, element);
            }
        }
        System.out.println(sum);
    }

    static void changeListContent(List<Integer> numbersList, int element) {
        for (int i = 0; i < numbersList.size(); i++) {
            if (numbersList.get(i) <= element) {
                numbersList.set(i, numbersList.get(i) + element);
            } else {
                numbersList.set(i, numbersList.get(i) - element);
            }
        }
    }
}