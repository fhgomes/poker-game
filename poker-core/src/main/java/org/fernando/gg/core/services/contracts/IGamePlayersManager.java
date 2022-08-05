package org.fernando.gg.core.services.contracts;

import java.util.List;

import org.fernando.gg.core.domain.GamePlayer;

public interface IGamePlayersManager {

	void joinGame(String gameRef, String playerName);
	void leaveGame(String gameRef, String playerName);

	/**
	 * Get the list of players in a game along with the total added value of all the cards each
	 * player holds;
	 * use face values of cards only.
	 * Sort the list in descending order, from the player with the highest to lowest hand value:
	 * For instance if player ‘A’ holds a 10 + King then her total value is 23 and player
	 * ‘B’ holds a 7 + Queen then his total value is 19, so player ‘A’ will be listed first
	 * followed by player ‘B
	 *
	 * @return
	 */
	List<GamePlayer> listPlayersInGame(String gameRef);

	/**
	 * Get the list of cards for a player
	 */
	void listCardsOfPlayer(String gameRef, String playerName);
}
