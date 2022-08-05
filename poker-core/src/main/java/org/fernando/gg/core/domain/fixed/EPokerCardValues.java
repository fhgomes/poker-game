package org.fernando.gg.core.domain.fixed;

import java.util.stream.Stream;

public enum EPokerCardValues {

	A("A", "Ace", 1),
	TWO("2", "2", 2),
	THREE("3", "3", 3),
	FOUR("4", "4", 4),
	FIVE("5", "5", 5),
	SIX("6", "6", 6),
	SEVEN("7", "7", 7),
	EIGHT("8", "8", 8),
	NINE("9", "9", 9),
	TEN("10", "10", 10),
	JACK("J", "Jack", 11),
	QUEEN("Q", "Queen", 12),
	KING("K", "King", 13);

	private final String visualKey;
	private final String visualName;
	private final int value;

	EPokerCardValues(String visualKey, String visualName, int value) {
		this.visualKey = visualKey;
		this.visualName = visualName;
		this.value = value;
	}

	public EPokerCardValues getByValue(int value) {
		return Stream
			.of(values())
			.filter(card -> card.value == value)
			.findFirst()
			.orElseThrow(() -> new RuntimeException("CardValue invalid: "+value));
	}

	public String getVisualKey() {
		return visualKey;
	}

	public String getVisualName() {
		return visualName;
	}

	public int getValue() {
		return value;
	}
}