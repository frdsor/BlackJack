package main.kotlin

import main.kotlin.Card.Suit
import java.io.File
import java.io.FileNotFoundException
import java.util.*

object Deck {
    @JvmStatic
    //Read and parse input file to Card
    //Returns arraylist of Cards
    fun createDeckFromFile(file: File): ArrayList<Card> {
        val deck = ArrayList<Card>()
        try {
            val scanner = Scanner(file)
            scanner.useDelimiter(", ")
            while (scanner.hasNext()) {
                val cardInfo = parseInput(scanner.next())!!
                val suit = parseSuit(cardInfo[0])
                val value = parseValue(cardInfo[1])
                val card = Card(Card.Value.valueOf(value), Suit.valueOf(suit))
                deck.add(card)
            }
            scanner.close()
        } catch (e: FileNotFoundException) {
            throw FileNotFoundException("Could not find input-file. $e")
        }
        return deck
    }

    //Splits input to suit and value strings
    private fun parseInput(card: String): Array<String>? {
        return if (card.isNotEmpty()) arrayOf(card.substring(0, 1), card.substring(1)) else null
    }

    //Returns a shuffled arraylist with 52 cards
    fun newShuffledDeck(): ArrayList<Card> {
        val deck = ArrayList<Card>()
        for (suit in Suit.values()) {
            for (value in Card.Value.values()) {
                deck.add(Card(value, suit))
            }
        }
        deck.shuffle()
        return deck
    }

    private fun parseValue(value: String?): String {
        return when (value) {
            "A" -> "ACE"
            "K" -> "KING"
            "Q" -> "QUEEN"
            "J" -> "JACK"
            "10" -> "TEN"
            "9" -> "NINE"
            "8" -> "EIGHT"
            "7" -> "SEVEN"
            "6" -> "SIX"
            "5" -> "FIVE"
            "4" -> "FOUR"
            "3" -> "THREE"
            "2" -> "TWO"
            else -> throw EnumConstantNotPresentException(Card.Value::class.java, value)
        }
    }

    private fun parseSuit(suit: String?): String {
        return when (suit) {
            "D" -> "DIAMONDS"
            "H" -> "HEARTS"
            "C" -> "CLUBS"
            "S" -> "SPADES"
            else -> throw EnumConstantNotPresentException(Suit::class.java, suit)
        }
    }
}