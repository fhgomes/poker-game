package org.fernando.gg.core.services;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.List;

import org.fernando.gg.core.DeckFactory;
import org.fernando.gg.core.domain.CardsDeckStats;
import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.fernando.gg.core.dto.CardSuitAndValueCountDTO;
import org.fernando.gg.core.dto.CardSuitCountDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameStatsServiceTest {

	@InjectMocks
	GameStatsService target;

	@Mock
	GameManagerService gameManager;

	@Mock
	GameRoom gameRoomMock;

	@Mock
	CardsDeckStats deckStatsMock;
	@Spy
	DeckFactory deckFactoryMock;

	@Test
	@DisplayName("When request count suits, should return results")
	void countCardsLeftBySuit() {
		when(gameManager.retrieveGame("ref123")).thenReturn(gameRoomMock);
		when(gameRoomMock.getCardsDeckStats()).thenReturn(deckStatsMock);
		when(deckStatsMock.countBySuit(ECardSuits.HEART)).thenReturn(12);
		when(deckStatsMock.countBySuit(ECardSuits.SPADE)).thenReturn(3);
		when(deckStatsMock.countBySuit(ECardSuits.CLUB)).thenReturn(4);
		when(deckStatsMock.countBySuit(ECardSuits.DIAMOND)).thenReturn(7);

		CardSuitCountDTO result = target.countCardsLeftBySuit("ref123");

		assertAll(
			() -> assertEquals(12, result.getCountHearts()),
			() -> assertEquals(3, result.getCountSpades()),
			() -> assertEquals(4, result.getCountClubs()),
			() -> assertEquals(7, result.getCountDiamonds())
		);
	}

	@Test
	@DisplayName("When request count cards, should return results")
	void listCardsLeft() {
		when(gameManager.retrieveGame("ref123")).thenReturn(gameRoomMock);
		when(gameRoomMock.getCardsDeckStats()).thenReturn(deckStatsMock);
		//default all
		when(deckStatsMock.countByGameCard(any(), any())).thenReturn(0);
		//specific test
		when(deckStatsMock.countByGameCard(ECardSuits.HEART, EPokerCardValues.KING)).thenReturn(1);

		CardSuitAndValueCountDTO result = target.listCardsLeft("ref123");

		assertAll(
			() -> assertEquals(1, result.getCountHearts().get(0).getCount()),
			() -> assertEquals("K", result.getCountHearts().get(0).getCardKey()),
			() -> assertEquals("Q", result.getCountHearts().get(1).getCardKey()),

			() -> assertEquals("K", result.getCountSpades().get(0).getCardKey()),
			() -> assertEquals("Q", result.getCountSpades().get(1).getCardKey())
		);
	}
}