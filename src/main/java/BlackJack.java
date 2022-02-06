package main.java;

import java.util.ArrayList;

public class BlackJack {

    private final ArrayList<Card> deck;
    private final Hand dealer;
    private final Hand player;

    public BlackJack(ArrayList<Card> deck, Hand dealer, Hand player) {
        this.deck = deck;
        this.dealer = dealer;
        this.player = player;
        play();
    }

    public String play() {
        player.addToHand(drawCard());
        dealer.addToHand(drawCard());
        player.addToHand(drawCard());
        dealer.addToHand(drawCard());
        if (checkBlackJack(player)) {
            printWin(player, dealer);
            return player.getName();
        }
        if (checkBlackJack(dealer)) {
            printWin(dealer, player);
            return dealer.getName();
        }
        while (player.getCurrentScore() < 17) {
            player.addToHand(drawCard());
            if (player.getCurrentScore() > 21) {
                printWin(dealer, player);
                return dealer.getName();
            }
        }
        while (dealer.getCurrentScore() <= player.getCurrentScore()) {
            dealer.addToHand(drawCard());
            if (dealer.getCurrentScore() > 21) {
                printWin(player, dealer);
                return player.getName();
            }
            if (dealer.getCurrentScore() > player.getCurrentScore()) {
                printWin(dealer, player);
                return dealer.getName();
            }
        }
        return "";
    }

    public void printWin(Hand winner, Hand looser) {
        System.out.println(winner.getName());
        System.out.println(winner.showCards());
        System.out.println(looser.showCards());
    }

    public boolean checkBlackJack(Hand hand) {
        return hand.getCurrentScore() == 21 && hand.hasAce();
    }

    public Card drawCard() {
        return deck.remove(0);
    }

}
