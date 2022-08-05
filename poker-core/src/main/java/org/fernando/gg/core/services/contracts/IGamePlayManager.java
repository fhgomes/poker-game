package org.fernando.gg.core.services.contracts;

public interface IGamePlayManager {

	/**
	 * Add a deck to a game deck
	 * once a deck has been added to a game deck it cannot be
	 * removed.
	 */
	void addDeckToGame(String gameRef);

	/**
	 * Get the count of how many cards per suit are left undealt in the game deck (example: 5
	 * hearts, 3 spades, etc.
	 */
	int countCardsLeftBySuit(String gameRef);
	/**
	 * Get the count of each card (suit and value) remaining in the game deck sorted by suit (
	 * hearts, spades, clubs, and diamonds) and face value from high value to low value (King,
	 * Queen, Jack, 10….2, Ace with value of 1)
	 */
	int listCardsLeft(String gameRef);

	/**
	 * Shuffle the game deck (shoe)
	 * ○ Shuffle returns no value, but results in the cards in the game deck being
	 * randomly permuted. Please do not use library-provided “shuffle” operations to
	 * implement this function. You may use library- provided random number
	 * generators in your solution.
	 * ○ Shuffle can be called at any time
	 */
	void shuffleShoe(String gameRef);

	/**
	 * Deal cards to a player in a game from the game deck
	 * ○ Specifically, for a game deck containing only one deck of cards,
	 * a call to shuffle followed by 52 calls to dealCards(1) for the same player should result in the
	 * caller being provided all 52 cards of the deck in a random order.
	 *
	 * If the caller then makes a 53rd call to dealCard(1), no card is dealt.
	 * This approach is to be followed if the game deck contains more than one deck
	 */
	void dealCards(String gameRef, String playerName, int cardsRequest);

}
