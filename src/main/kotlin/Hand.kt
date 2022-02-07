package main.kotlin

import java.util.ArrayList

class Hand(val name: String) {
    private val hand: ArrayList<Card> = ArrayList()
    private var hasAce = false

    fun addToHand(card: Card) {
        hand.add(card)
        if (card.isAce) {
            hasAce = true
        }
    }

    fun getScore(): Int {
        var score = 0
        for (card in hand) {
            score += card.getCardValue()
        }
        return score
    }

    fun showCards(): String {
        return name + ": " + java.lang.String.join(", ", hand.toString().replace("[", "").replace("]", ""))
    }

    fun hasAce(): Boolean {
        return hasAce
    }

}



