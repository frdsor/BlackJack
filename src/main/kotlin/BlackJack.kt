package main.kotlin

import java.util.ArrayList

class BlackJack(private val deck: ArrayList<Card>, private val dealer: Hand, private val player: Hand) {
    init {
        play()
    }

    private fun play(): String {
        player.addToHand(drawCard())
        dealer.addToHand(drawCard())
        player.addToHand(drawCard())
        dealer.addToHand(drawCard())
        if (checkBlackJack(player)) {
            printWin(player, dealer)
            return player.name
        }
        if (checkBlackJack(dealer)) {
            printWin(dealer, player)
            return dealer.name
        }
        while (player.getScore() < 17) {
            player.addToHand(drawCard())
            if (player.getScore() > 21) {
                printWin(dealer, player)
                return dealer.name
            }
        }
        while (dealer.getScore() <= player.getScore()) {
            dealer.addToHand(drawCard())
            if (dealer.getScore() > 21) {
                printWin(player, dealer)
                return player.name
            }
            if (dealer.getScore() > player.getScore()) {
                printWin(dealer, player)
                return dealer.name
            }
        }
        printWin(dealer,player)
        return dealer.name
    }

    private fun printWin(winner: Hand, looser: Hand) {
        println(winner.name)
        println(winner.showCards())
        println(looser.showCards())
    }

    private fun checkBlackJack(hand: Hand): Boolean {
        return hand.getScore() == 21 && hand.hasAce()
    }

    private fun drawCard(): Card {
        return deck.removeAt(0)
    }
}