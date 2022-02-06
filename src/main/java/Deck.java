package main.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Deck {

    public static ArrayList<Card> createDeckFromFile(File file) {
        ArrayList<Card> deck = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            scanner.useDelimiter(", ");
            while (scanner.hasNext()) {
                String[] cardInfo = parseInput(scanner.next());
                assert cardInfo != null;
                String suit = parseSuit(cardInfo[0]);
                String value = parseValue(cardInfo[1]);
                Card card = new Card(Card.Value.valueOf(value), Card.Suit.valueOf(suit));
                deck.add(card);
            }
            scanner.close();
        } catch (FileNotFoundException | NullPointerException e) {
            System.out.println("Could not parse input-file. " + e);
        }
        return deck;
    }

    public static String[] parseInput(String card) {
        return card.length() > 0 ? new String[]{card.substring(0, 1), card.substring(1)} : null;
    }

    public static ArrayList<Card> getNewShuffledDeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Value value : Card.Value.values()) {
                deck.add(new Card(value, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
    }

    public static String parseSuit(String suit) {
        return switch (suit) {
            case "D" -> "DIAMONDS";
            case "H" -> "HEARTS";
            case "C" -> "CLUBS";
            case "S" -> "SPADES";
            default -> throw new EnumConstantNotPresentException(Card.Suit.class, suit);
        };
    }

    public static String parseValue(String value) {
        return switch (value) {
            case "A" -> "ACE";
            case "K" -> "KING";
            case "Q" -> "QUEEN";
            case "J" -> "JACK";
            case "10" -> "TEN";
            case "9" -> "NINE";
            case "8" -> "EIGHT";
            case "7" -> "SEVEN";
            case "6" -> "SIX";
            case "5" -> "FIVE";
            case "4" -> "FOUR";
            case "3" -> "THREE";
            case "2" -> "TWO";
            default -> throw new EnumConstantNotPresentException(Card.Value.class, value);
        };
    }
}



