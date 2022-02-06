package main.java;

import java.io.File;

public class Casino {

    public static void main(String[] args) {
        Hand sam = new Hand("Sam");
        Hand dealer = new Hand("Dealer");

        if (args.length > 0) {
            File file = new File(args[0]);
            if (file.exists()) {
                new BlackJack(Deck.createDeckFromFile(file), dealer, sam);
            }

        } else {
            new BlackJack(Deck.getNewShuffledDeck(), dealer, sam);
        }
    }

}
