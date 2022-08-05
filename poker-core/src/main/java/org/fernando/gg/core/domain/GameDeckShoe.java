package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

public class GameDeckShoe {
	private final List<GameCard> currentCards;

	public GameDeckShoe() {
		currentCards = new ArrayList<>();
	}

	public void addDeck(CardsDeck newDeck) {
		currentCards.addAll(newDeck.getCards());
	}
}
