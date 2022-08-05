package org.fernando.gg.core.services.contracts;

public interface IGamePlayManager {

	/**
	 * Get the list of cards for a player
	 */
	void listCardsOfPlayer(String gameRef, String playerName);

	/**
	 * Get the list of players in a game along with the total added value of all the cards each
	 * player holds; use face values of cards only. Then sort the list in descending order, from
	 * the player with the highest value hand to the player with the lowest value hand:
	 * ○ For instance if player ‘A’ holds a 10 + King then her total value is 23 and player
	 * ‘B’ holds a 7 + Queen then his total value is 19, so player ‘A’ will be listed first
	 * followed by player ‘B
	 */
	void listPlayersInGame(String gameRef);

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
