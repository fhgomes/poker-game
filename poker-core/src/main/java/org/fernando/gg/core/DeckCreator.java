package org.fernando.gg.core;

import org.fernando.gg.core.domain.PokerDeck;
import org.springframework.stereotype.Service;

@Service
public class DeckCreator {

	public PokerDeck createPokerDeck() {
		return new PokerDeck();
	}
}
