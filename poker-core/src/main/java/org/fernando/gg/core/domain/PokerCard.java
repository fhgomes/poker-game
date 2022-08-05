package org.fernando.gg.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;

@AllArgsConstructor
@Getter
public class PokerCard {

	private ECardSuits suit;
	private EPokerCardValues value;
}
