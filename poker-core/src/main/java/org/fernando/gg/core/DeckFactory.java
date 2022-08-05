package org.fernando.gg.core;

import java.util.ArrayList;
import java.util.List;

import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.domain.CardsDeck;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.springframework.stereotype.Component;

@Component
public class DeckFactory {

	public CardsDeck createPokerDeck() {
		List<GameCard> gameCards = new ArrayList<>();
		for (ECardSuits cardSuit : ECardSuits.values()) {
			addCardsWithSuit(gameCards, cardSuit);
		}

		return new CardsDeck(gameCards);
	}

	private void addCardsWithSuit(List<GameCard> gameCards, ECardSuits cardSuit) {
		for (EPokerCardValues cardValue : EPokerCardValues.values()) {
			gameCards.add(createCard(cardSuit, cardValue));
		}
	}

	private GameCard createCard(ECardSuits cardSuit, EPokerCardValues cardValue) {
		return new GameCard(cardSuit, cardValue);
	}
}
