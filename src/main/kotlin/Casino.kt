package main.kotlin

import main.kotlin.Deck.createDeckFromFile
import main.kotlin.Deck.newShuffledDeck
import kotlin.jvm.JvmStatic
import java.io.File

object Casino {

    /*
    -Initialize two players.
    -If an argument is provided and file exist, a deck will be created from it.
    -Or else BlackJack constructor will be provided with a generated deck of 52 unique cards.
    */
    @JvmStatic
    fun main(args: Array<String>) {
        val sam = Hand("Sam")
        val dealer = Hand("Dealer")

        if (args.isNotEmpty()) {
            val file = File(args[0])
            if (file.exists()) {
                BlackJack(createDeckFromFile(file), dealer, sam)
            } else {
                println("### No such file, check input ###")
            }
        } else {
            BlackJack(newShuffledDeck(), dealer, sam)
        }
    }
}