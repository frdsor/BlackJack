package main.kotlin

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotEquals
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

internal class HandTest {

    private val hand = Hand("A name")

    @Test
    @Disabled
    fun addToHand() {
    }

    @Test
    fun getScore() {
        val ace = Card(Card.Value.ACE, Card.Suit.CLUBS)
        val two = Card(Card.Value.TWO, Card.Suit.HEARTS)
        hand.addToHand(ace)
        assertEquals(this.hand.getScore(), 11)
        hand.addToHand(two)
        assertEquals(this.hand.getScore(), 13)
    }

    @Test
    fun showCards() {
        val two = Card(Card.Value.TWO, Card.Suit.HEARTS)
        hand.addToHand(two)
        assertEquals(hand.showCards(), "A name: H2")
    }

    @Test
    fun hasAce() {
        val ace = Card(Card.Value.ACE, Card.Suit.CLUBS)
        hand.addToHand(ace)
        assertEquals(hand.hasAce(), true)
    }

    @Test
    fun getName() {
        assertNotEquals(hand.name, "Sam")
        assertEquals(hand.name, "A name")
    }
}