package main.kotlin

class Card(private val cardValue: Value, private val cardSuit: Suit) {

    fun getCardValue(): Int {
        return cardValue.value
    }

    val isAce: Boolean
        get() = cardValue.name.equals("ACE", ignoreCase = true)

    override fun toString(): String {
        return cardSuit.toString() + cardValue.toString()
    }

    enum class Value(val value: Int) {
        TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6), SEVEN(7), EIGHT(8),
        NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        override fun toString(): String {
            return when (this) {
                ACE -> "A"
                KING -> "K"
                QUEEN -> "Q"
                JACK -> "J"
                TEN -> "10"
                NINE -> "9"
                EIGHT -> "8"
                SEVEN -> "7"
                SIX -> "6"
                FIVE -> "5"
                FOUR -> "4"
                THREE -> "3"
                TWO -> "2"
            }
        }
    }

    enum class Suit {
        CLUBS, HEARTS, DIAMONDS, SPADES;

        override fun toString(): String {
            return when (this) {
                CLUBS -> "C"
                HEARTS -> "H"
                DIAMONDS -> "D"
                SPADES -> "S"
            }
        }
    }
}