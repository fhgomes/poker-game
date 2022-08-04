package org.fernando.gg.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PokerCard {

	private ECardSuits suit;
	private EPokerCardValues value;
}
