package StreamsFilesDirectoriesExercise;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountCharacterTypes {
    public static void main(String[] args) throws IOException {

        Path path = Path.of("C:\\Users\\I353529\\Documents\\SoftUni\\Exercises Resources\\input.txt");
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(path);
        } catch (Exception io) {
            System.out.println("Another error with reading file");
        }

        Map<String, Integer> symbolsCount = new HashMap<>();
        symbolsCount.put("vowels", 0);
        symbolsCount.put("consonants", 0);
        symbolsCount.put("punctuations", 0);

        for (String line : lines) {
            for (char symbol : line.toCharArray()) {
                if (symbol == ' ') {
                    continue;
                } else if (isVowel(symbol)) {
                    symbolsCount.put("vowels", symbolsCount.get("vowels") + 1);
                } else if (isPunctional(symbol)) {
                    symbolsCount.put("punctuations", symbolsCount.get("punctuations") + 1);
                } else {
                    symbolsCount.put("consonants", symbolsCount.get("consonants") + 1);
                }
            }
        }

        BufferedWriter writer = new BufferedWriter(new FileWriter("output_task_4.txt"));

        writer.write("Vowels: " + symbolsCount.get("vowels"));
        writer.newLine();

        writer.write("Consonants: " + symbolsCount.get("consonants"));
        writer.newLine();

        writer.write("Punctuation: " + symbolsCount.get("punctuations"));
        writer.close();

    }

    private static boolean isPunctional(char symbol) {
        return symbol == '!' || symbol == ',' || symbol == '.' || symbol == '?';
    }

    private static boolean isVowel(char symbol) {
        return symbol == 'a' || symbol == 'e' || symbol == 'i' || symbol == 'o' || symbol == 'u';
    }
}