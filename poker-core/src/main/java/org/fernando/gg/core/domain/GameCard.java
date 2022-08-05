package org.fernando.gg.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;

@AllArgsConstructor
@Getter
public class GameCard {

	private ECardSuits suit;
	private EPokerCardValues value;

	public int getCardValue() {
		return value.getValue();
	}

	@Override
	public String toString() {
		return "GameCard[" + suit.getSymbol() +
			"-" + value.getVisualKey() +
			']';
	}
}
