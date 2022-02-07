package main.kotlin

import java.util.ArrayList

class BlackJack(private val deck: ArrayList<Card>, private val dealer: Hand, private val player: Hand) {
    init {
        startGame()
    }

    private fun startGame() {
        while (play()) {
            play()
        }
    }

    /*
    -Each hand draws 2 cards, then checks for blackjack. Player will be checked first.
    -Then player will draw cards until he hits a score over 17, If player scores over 21, dealer wins.
    -Dealer will draw until score is higher than players total card value, If dealer scores over 21, player wins.
    -Return false to Exit the game.
    */
    private fun play(): Boolean {
        player.addToHand(drawCard())
        dealer.addToHand(drawCard())
        player.addToHand(drawCard())
        dealer.addToHand(drawCard())
        if (checkBlackJack(player)) {
            printWin(player, dealer)
            return false
        }
        if (checkBlackJack(dealer)) {
            printWin(dealer, player)
            return false
        }
        while (player.getScore() < 17) {
            player.addToHand(drawCard())
            if (player.getScore() > 21) {
                printWin(dealer, player)
                return false
            }
        }
        while (dealer.getScore() <= player.getScore()) {
            dealer.addToHand(drawCard())
            if (dealer.getScore() > 21) {
                printWin(player, dealer)
                return false
            }
            if (dealer.getScore() > player.getScore()) {
                printWin(dealer, player)
                return false
            }
        }
        //Dealer wins
        printWin(dealer, player)
        return false
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