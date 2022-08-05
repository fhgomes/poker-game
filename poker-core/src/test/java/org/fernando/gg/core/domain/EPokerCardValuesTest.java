package org.fernando.gg.core.domain;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EPokerCardValuesTest {

	@Test
	@DisplayName("When given key cards, return correct value")
	void shouldGetCorrectKeyValues() {
		assertAll(
			() -> assertEquals(1, EPokerCardValues.A.getValue()),
			() -> assertEquals(11, EPokerCardValues.JACK.getValue()),
			() -> assertEquals(12, EPokerCardValues.QUEEN.getValue()),
			() -> assertEquals(13, EPokerCardValues.KING.getValue())
		);
	}

	@Test
	@DisplayName("When given key cards, return correct char")
	void shouldGetCorrectKey() {
		assertAll(
			() -> assertEquals("A", EPokerCardValues.A.getVisualKey()),
			() -> assertEquals("J", EPokerCardValues.JACK.getVisualKey()),
			() -> assertEquals("Q", EPokerCardValues.QUEEN.getVisualKey()),
			() -> assertEquals("K", EPokerCardValues.KING.getVisualKey())
		);
	}

	@DisplayName("When given number cards, return correct value")
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
	void shouldGetCorrectNumberValue(int cardValue) {
		assertEquals(cardValue,EPokerCardValues.A.getByValue(cardValue).getValue());
	}

	@DisplayName("When given number cards, return correct key")
	@ParameterizedTest
	@ValueSource(ints = {2, 3, 4, 5, 6, 7, 8, 9, 10})
	void shouldGetCorrectNumberKey(int cardValue) {
		assertEquals(String.valueOf(cardValue), EPokerCardValues.A.getByValue(cardValue).getVisualKey());
	}
}