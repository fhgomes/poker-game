package org.fernando.gg.core.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpServerErrorException;

class GameRoomTest {

	GameRoom target;

	@BeforeEach
	void setUp() {
		target = new GameRoom("ref123", "room01");
	}

	@Test
	@DisplayName("When add new player should have correct results")
	void joinPlayer() {
		target.joinPlayer("fer01");

		assertAll(
			() -> assertTrue(target.listCardsOfPlayer("fer01").isEmpty()),
			() -> assertEquals(0, target.getPlayers().get(0).getHandValue())
		);
	}

	@Test
	@DisplayName("When remove player, should return player not exists")
	void removePlayer() {
		target.joinPlayer("fer01");
		target.joinPlayer("fer02");
		target.removePlayer("fer01");

		assertThrows(
			HttpServerErrorException.class,
			() -> target.listCardsOfPlayer("fer01")
		);
	}

	@Test
	@DisplayName("When add deck, should update values")
	void addDeck() {
		target.joinPlayer("fer01");
		target.joinPlayer("fer02");
		ArrayList<GameCard> cards = new ArrayList<>();
		cards.add(new GameCard(ECardSuits.HEART, EPokerCardValues.A));
		cards.add(new GameCard(ECardSuits.DIAMOND, EPokerCardValues.JACK));
		cards.add(new GameCard(ECardSuits.CLUB, EPokerCardValues.TEN));

		target.addDeck(new CardsDeck(cards));

		CardsDeckStats deckStats = target.getCardsDeckStats();
		assertAll(
			() -> assertEquals(1, deckStats.countBySuit(ECardSuits.HEART)),
			() -> assertEquals(1, deckStats.countBySuit(ECardSuits.DIAMOND)),
			() -> assertEquals(1, deckStats.countBySuit(ECardSuits.CLUB)),
			() -> assertEquals(0, deckStats.countBySuit(ECardSuits.SPADE)),
			() -> assertEquals(0, target.listCardsOfPlayer("fer01").size()),
			() -> assertEquals(0, target.listCardsOfPlayer("fer02").size()),
			() -> assertEquals(0, target.getPlayers().get(0).getHandValue()),
			() -> assertEquals(0, target.getPlayers().get(1).getHandValue())
		);
	}

	@Test
	@DisplayName("When deal cards, should update values")
	void dealCards() {
		target.joinPlayer("fer01");
		target.joinPlayer("fer02");
		ArrayList<GameCard> cards = new ArrayList<>();
		cards.add(new GameCard(ECardSuits.HEART, EPokerCardValues.A));
		cards.add(new GameCard(ECardSuits.DIAMOND, EPokerCardValues.JACK));
		cards.add(new GameCard(ECardSuits.CLUB, EPokerCardValues.TEN));

		target.addDeck(new CardsDeck(cards));
		target.dealCards("fer01", 2);

		assertAll(
			() -> assertEquals(2, target.listCardsOfPlayer("fer01").size()),
			() -> assertEquals(0, target.listCardsOfPlayer("fer02").size()),
			() -> assertTrue(target.getPlayers().get(0).getHandValue() > 0),
			() -> assertEquals(0, target.getPlayers().get(1).getHandValue())
		);
	}
}