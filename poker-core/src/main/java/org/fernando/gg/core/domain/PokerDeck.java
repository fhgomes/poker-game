package org.fernando.gg.core.domain;

import java.util.List;

public class PokerDeck {

	private final List<PokerCard> cards;

	public PokerDeck(List<PokerCard> cards) {
		this.cards = cards;
	}

	public int countCards() {
		return cards.size();
	}
}
