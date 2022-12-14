package org.fernando.gg.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fernando.gg.core.domain.CardsDeck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeckFactoryTest {

	@InjectMocks
	DeckFactory target;

	@Test
	@DisplayName("When create poker deck should return 52 cards")
	void createPokerDeck() {
		CardsDeck createdDeck = target.createPokerDeck();
		assertEquals(52, createdDeck.countCards());

	}
}