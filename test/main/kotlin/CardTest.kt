package main.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CardTest {

    private val ace = Card(Card.Value.ACE, Card.Suit.CLUBS)
    private val two = Card(Card.Value.TWO, Card.Suit.HEARTS)

    @Test
    fun getCardValue() {
        assertEquals(ace.getCardValue(), 11)
        assertEquals(two.getCardValue(), 2)
        assertEquals(Card.Value.SEVEN.value, 7)
    }

    @Test
    fun isAce() {
        assert(this.ace.isAce)
        assertEquals(ace.isAce, true)
        assertEquals(two.isAce, false)
    }

    @Test
    fun testToString() {
        assertEquals(ace.toString(), "CA")
        assertEquals(two.toString(), "H2")
    }
}