package org.fernando.gg.core;

import org.fernando.gg.core.domain.PokerDeck;
import org.springframework.stereotype.Component;

@Component
public class DeckFactory {

	public PokerDeck createPokerDeck() {
		return new PokerDeck();
	}
}
