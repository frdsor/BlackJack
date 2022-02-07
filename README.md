# BlackJack

A kotlin program for simulating a blackjack game.

Should be able to read a file containing a deck of cards, by taking reference to the file as cmd arg.
If no file is provided it will create a shuffeld deck containing 52 cards

"Sam" and "Dealer" will draw cards and simulate a game until one wins.
- Both starts with 2 cards
- Ace is 11
- If both draw BlackJack, Sam wins
- Sam will draw until score > 17
- Dealer wins if Sams score < 21 (bust)
- Dealer must draw until score is more then Sam's
- Highest score wins

..

**How to compile from command line:**

```
kotlinc Casino.kt BlackJack.kt Card.kt Deck.kt Hand.kt -include-runtime -d Casino.jar
```

**How to run from command line:**

```
java -jar Casino.jar
```
