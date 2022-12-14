package org.fernando.gg.core.services.contracts;

import java.util.List;

import org.fernando.gg.core.domain.GameCard;

public interface IGamePlayManager {

	/**
	 * Add a deck to a game deck
	 * once a deck has been added to a game deck it cannot be
	 * removed.
	 */
	void addDeckToGame(String gameRef);

	/**
	 * Shuffle the game deck (shoe)
	 * ○ Shuffle returns no value, but results in the cards in the game deck being
	 * randomly permuted. Please do not use library-provided “shuffle” operations to
	 * implement this function. You may use library- provided random number
	 * generators in your solution.
	 * ○ Shuffle can be called at any time
	 */
	void shuffleCards(String gameRef);

	/**
	 * Deal cards to a player in a game from the game deck
	 * ○ Specifically, for a game deck containing only one deck of cards,
	 * a call to shuffle followed by 52 calls to dealCards(1) for the same player should result in the
	 * caller being provided all 52 cards of the deck in a random order.
	 * <p>
	 * If the caller then makes a 53rd call to dealCard(1), no card is dealt.
	 * This approach is to be followed if the game deck contains more than one deck
	 *
	 * @return
	 */
	List<GameCard> dealCards(String gameRef, String playerName, int cardsRequest);

}