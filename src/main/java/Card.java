package main.java;

public class Card {

    public int getCardValue() {
        return cardValue.value;
    }

    public boolean isAce(){
        return cardValue.name().equalsIgnoreCase("ACE");
    }

    
    public String toString() {
        return cardSuit.toString() + cardValue.toString();
    }

    private final Value cardValue;
    private final Suit cardSuit;

    public Card(Value cardValue, Suit cardSuit) {
        this.cardValue = cardValue;
        this.cardSuit = cardSuit;
    }

    enum Value {

        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7),
        EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        private final int value;
        Value(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return switch (this){
                case ACE -> "A";
                case KING -> "K";
                case QUEEN -> "Q";
                case JACK -> "J";
                case TEN -> "10";
                case NINE -> "9";
                case EIGHT -> "8";
                case SEVEN -> "7";
                case SIX -> "6";
                case FIVE -> "5";
                case FOUR -> "4";
                case THREE -> "3";
                case TWO -> "2";
            };
        }
    }
    enum Suit {
        CLUBS, HEARTS, DIAMONDS, SPADES;

        @Override
        public String toString() {
            return switch (this){
                case CLUBS -> "C";
                case HEARTS -> "H";
                case DIAMONDS -> "D";
                case SPADES -> "S";
            };
        }
    }
}


