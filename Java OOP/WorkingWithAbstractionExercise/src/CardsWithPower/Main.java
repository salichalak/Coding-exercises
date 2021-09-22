package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String currentRank = scanner.nextLine();
        String currentSuit = scanner.nextLine();

        Card card = new Card(CardSuits.valueOf(currentSuit), CardRanks.valueOf(currentRank));

        System.out.printf("Card name: %s of %s; Card power: %d", card.getCardRank(), card.getCardSuit(), card.getPower());
    }
}