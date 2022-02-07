package main.kotlin

import main.kotlin.Deck.createDeckFromFile
import main.kotlin.Deck.newShuffledDeck
import kotlin.jvm.JvmStatic
import java.io.File

object Casino {
    @JvmStatic
    fun main(args: Array<String>) {
        val sam = Hand("Sam")
        val dealer = Hand("Dealer")
        if (args.isNotEmpty()) {
            val file = File(args[0])
            if (file.exists()) {
                BlackJack(createDeckFromFile(file), dealer, sam)
            }
        } else {
            BlackJack(newShuffledDeck(), dealer, sam)
        }
    }
}