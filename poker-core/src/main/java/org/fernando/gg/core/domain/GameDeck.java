package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

public class GameDeck {
	private final List<CardsDeck> currentDecks;

	public GameDeck() {
		currentDecks = new ArrayList<>();
	}

	public void addDeck(CardsDeck newDeck) {
		currentDecks.add(newDeck);
	}
}
