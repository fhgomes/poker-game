package org.fernando.gg.core;

import java.util.ArrayList;
import java.util.List;

import org.fernando.gg.core.domain.PokerCard;
import org.fernando.gg.core.domain.PokerDeck;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.springframework.stereotype.Component;

@Component
public class DeckFactory {

	public PokerDeck createPokerDeck() {
		List<PokerCard> pokerCards = new ArrayList<>();
		for (ECardSuits cardSuit : ECardSuits.values()) {
			addCardsWithSuit(pokerCards, cardSuit);
		}

		return new PokerDeck(pokerCards);
	}

	private void addCardsWithSuit(List<PokerCard> pokerCards, ECardSuits cardSuit) {
		for (EPokerCardValues cardValue : EPokerCardValues.values()) {
			pokerCards.add(createCard(cardSuit, cardValue));
		}
	}

	private PokerCard createCard(ECardSuits cardSuit, EPokerCardValues cardValue) {
		return new PokerCard(cardSuit, cardValue);
	}
}
