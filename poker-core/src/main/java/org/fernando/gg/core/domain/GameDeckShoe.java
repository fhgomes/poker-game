package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

public class GameDeckShoe {
	private final List<GameCard> currentCards;

	public GameDeckShoe() {
		currentCards = new ArrayList<>();
	}

	public void addDeck(CardsDeck newDeck) {
		currentCards.addAll(newDeck.getCards());
	}

	public Optional<GameCard> retrieveCard() {
		if (currentCards.isEmpty()) {
			return Optional.empty();
		}
		return Optional.of(currentCards.remove(currentCards.size()-1));
	}

	public void shufflePosition() {
		if (currentCards.isEmpty()) {
			return;
		}

		for (int i = 0; i < 52; i++) {
			changeCardPosition();
		}
	}

	private void changeCardPosition() {
		int currPos = new Random().nextInt(currentCards.size() - 1);
		int newPos = new Random().nextInt(currentCards.size() - 1);
		GameCard shufflingCard = currentCards.remove(currPos);
		currentCards.add(newPos, shufflingCard);
	}
}
