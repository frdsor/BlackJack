package main.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.io.File

internal class DeckTest {

    private val deck = Deck
    private val file = File("src/main/resources/test.txt")

    @Test
    fun createDeckFromFile() {
        val deck = deck.createDeckFromFile(file)
        assertEquals(deck[0].toString(), "HA")
        assertEquals(deck[2].toString(), "SK")
    }

    @Test
    fun newShuffledDeck() {
        val deck = deck.newShuffledDeck()
        assertEquals(deck.size, 52)
    }
}