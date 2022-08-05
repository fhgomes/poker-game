package org.fernando.gg.core.domain;

import java.util.List;

public class CardsDeck {

	private final List<GameCard> cards;

	public CardsDeck(List<GameCard> cards) {
		this.cards = cards;
	}

	public int countCards() {
		return cards.size();
	}
}
