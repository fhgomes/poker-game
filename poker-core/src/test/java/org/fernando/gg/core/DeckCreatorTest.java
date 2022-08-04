package org.fernando.gg.core;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fernando.gg.core.domain.PokerDeck;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DeckCreatorTest {

	@InjectMocks
	DeckCreator deckCreator;

	@DisplayName("When create poker deck should return 52 cards")
	@Test
	void createPokerDeck() {
		PokerDeck createdDeck = deckCreator.createPokerDeck();
		assertEquals(52, createdDeck.countCards());

	}
}