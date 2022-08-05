package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

public class GameDeck {
	private final List<PokerDeck> currentDecks;


	public GameDeck() {
		currentDecks = new ArrayList<>();
	}

	public void addDeck(PokerDeck newDeck) {
		currentDecks.add(newDeck);
	}
}
