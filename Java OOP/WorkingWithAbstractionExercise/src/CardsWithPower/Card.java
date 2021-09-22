package CardsWithPower;

public class Card {
    private CardSuits cardSuit;
    private CardRanks cardRank;
    private int power;

    public Card(CardSuits cardSuit, CardRanks cardRank) {
        this.cardSuit = cardSuit;
        this.cardRank = cardRank;
    }

    public int getPower() {
        return this.cardSuit.getSuitPower() + this.cardRank.getPowerRank();
    }

    public CardSuits getCardSuit() {
        return this.cardSuit;
    }

    public CardRanks getCardRank() {
        return this.cardRank;
    }
}