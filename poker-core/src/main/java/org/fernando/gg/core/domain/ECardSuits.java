package org.fernando.gg.core.domain;

public enum ECardSuits {

	HEART(1, "S2", "Hearts", "♥", "U+2665"),
	SPADE(2, "SP", "Spades", "♠", "U+2660"),
	CLUB(3, "CL", "Clubs", "♣", "U+2663"),
	DIAMOND(4, "DI", "Diamonds", "♦", "U+2666");

	private final int order;
	private final String visualKey;
	private final String visualName;
	private final String symbol;
	private final String unicode;

	ECardSuits(int order, String visualKey, String visualName, String symbol, String unicode) {
		this.order = order;
		this.visualKey = visualKey;
		this.visualName = visualName;
		this.symbol = symbol;
		this.unicode = unicode;
	}

	public int getOrder() {
		return order;
	}

	public String getVisualKey() {
		return visualKey;
	}

	public String getVisualName() {
		return visualName;
	}

	public String getSymbol() {
		return symbol;
	}

	public String getUnicode() {
		return unicode;
	}
}
