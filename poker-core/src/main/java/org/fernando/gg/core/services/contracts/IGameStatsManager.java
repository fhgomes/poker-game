package org.fernando.gg.core.services.contracts;

import org.fernando.gg.core.dto.CardSuitAndValueCountDTO;
import org.fernando.gg.core.dto.CardSuitCountDTO;

public interface IGameStatsManager {

	/**
	 * Get the count of how many cards per suit are left undealt in the game deck (example: 5
	 * hearts, 3 spades, etc.
	 */
	CardSuitCountDTO countCardsLeftBySuit(String gameRef);
	/**
	 * Get the count of each card (suit and value) remaining in the game deck sorted by suit (
	 * hearts, spades, clubs, and diamonds) and face value from high value to low value (King,
	 * Queen, Jack, 10….2, Ace with value of 1)
	 */
	CardSuitAndValueCountDTO listCardsLeft(String gameRef);

}
