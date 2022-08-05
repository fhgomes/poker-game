package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class GamePlayer {
	private final String playerName;
	private final List<GameCard> handCards;
	private int handValue;

	public GamePlayer(String playerName) {
		this.playerName = playerName;
		this.handCards = new ArrayList<>();
		this.handValue = 0;
	}

	public void receiveCard(GameCard card) {
		handCards.add(card);
		handValue+= card.getCardValue();
	}
}