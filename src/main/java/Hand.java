package main.java;

import java.util.ArrayList;

public class Hand {

    private final ArrayList<Card> hand;
    private int currentScore;
    private final String name;
    private boolean hasAce;

    public String getName() {
        return name;
    }

    public Hand(String name){
        this.name = name;
        this.hand = new ArrayList<>();
        currentScore = 0;
    }

    public void addToHand(Card card){
        hand.add(card);
        if(card.isAce()) {
            hasAce = true;
        }
        currentScore += card.getCardValue();
    }

    public String showCards(){
        return this.name + ": " + String.join(", ",hand.toString().replace("[", "").replace("]", ""));
    }

    public boolean hasAce(){
        return hasAce;
    }

    public int getCurrentScore(){
        return currentScore;
    }
}
