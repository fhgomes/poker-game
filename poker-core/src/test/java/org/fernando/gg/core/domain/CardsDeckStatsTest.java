package org.fernando.gg.core.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.fernando.gg.core.DeckFactory;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class CardsDeckStatsTest {

	CardsDeckStats target;

	@BeforeEach
	void setUp() {
		target = new CardsDeckStats();
	}

	@Nested
	class testSuitCounts {
		@Test
		@DisplayName("When add one deck, return right values for suits")
		void addCards() {
			List<GameCard> cards = new DeckFactory().createPokerDeck().getCards();
			cards.forEach(card -> target.addCard(card));

			assertAll(
				() -> assertEquals(13, target.countBySuit(ECardSuits.HEART)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.SPADE)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.CLUB)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.DIAMOND))
			);
		}

		@Test
		@DisplayName("When add one one card to specific suit, return right values")
		void addCardToClub() {
			List<GameCard> cards = new DeckFactory().createPokerDeck().getCards();
			cards.forEach(card -> target.addCard(card));

			target.addCard(new GameCard(ECardSuits.CLUB, EPokerCardValues.A));

			assertAll(
				() -> assertEquals(13, target.countBySuit(ECardSuits.HEART)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.SPADE)),
				() -> assertEquals(14, target.countBySuit(ECardSuits.CLUB)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.DIAMOND))
			);
		}

		@Test
		@DisplayName("When remove specific card, update suit values")
		void removeCard() {
			List<GameCard> cards = new DeckFactory().createPokerDeck().getCards();
			cards.forEach(card -> target.addCard(card));

			target.removeCard(new GameCard(ECardSuits.CLUB, EPokerCardValues.A));

			assertAll(
				() -> assertEquals(13, target.countBySuit(ECardSuits.HEART)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.SPADE)),
				() -> assertEquals(12, target.countBySuit(ECardSuits.CLUB)),
				() -> assertEquals(13, target.countBySuit(ECardSuits.DIAMOND))
			);
		}
	}

	@Nested
	class testSuitAndValueCounts {
		@Test
		@DisplayName("When add one deck, return right values for suits and values")
		void addCards() {
			List<GameCard> cards = new DeckFactory().createPokerDeck().getCards();
			cards.forEach(card -> target.addCard(card));

			assertAll(
				() -> assertEquals(1, target.countByGameCard(ECardSuits.HEART, EPokerCardValues.A)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.SPADE, EPokerCardValues.TWO)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.CLUB, EPokerCardValues.SEVEN)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.DIAMOND, EPokerCardValues.QUEEN))
			);
		}

		@Test
		@DisplayName("When add one spade-A, return right values for suits and values")
		void addCardSpade() {
			List<GameCard> cards = new DeckFactory().createPokerDeck().getCards();
			cards.forEach(card -> target.addCard(card));

			target.addCard(new GameCard(ECardSuits.SPADE, EPokerCardValues.A));

			assertAll(
				() -> assertEquals(1, target.countByGameCard(ECardSuits.HEART, EPokerCardValues.A)),
				() -> assertEquals(2, target.countByGameCard(ECardSuits.SPADE, EPokerCardValues.A)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.CLUB, EPokerCardValues.A)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.DIAMOND, EPokerCardValues.A))
			);
		}

		@Test
		@DisplayName("When add one spade-A, return right values for suits and values")
		void removeCardSpade() {
			List<GameCard> cards = new DeckFactory().createPokerDeck().getCards();
			cards.forEach(card -> target.addCard(card));

			target.removeCard(new GameCard(ECardSuits.SPADE, EPokerCardValues.A));

			assertAll(
				() -> assertEquals(1, target.countByGameCard(ECardSuits.HEART, EPokerCardValues.A)),
				() -> assertEquals(0, target.countByGameCard(ECardSuits.SPADE, EPokerCardValues.A)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.CLUB, EPokerCardValues.A)),
				() -> assertEquals(1, target.countByGameCard(ECardSuits.DIAMOND, EPokerCardValues.A))
			);
		}
	}
}