package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class GameRoom {
	private final String gameRef;
	private final String roomName;
	private final List<String> players = new ArrayList<>();
	private final GameDeck gameDeck;

	public GameRoom(String gameRef, String roomName) {
		this.gameRef = gameRef;
		this.roomName = roomName;
		this.gameDeck = new GameDeck();
	}

	public void joinPlayer(String playerName) {
		players.add(playerName);
	}

	public void removePlayer(String playerName) {
		players.remove(playerName);
	}

	public void addDeck(CardsDeck cardsDeck) {
		gameDeck.addDeck(cardsDeck);
	}
}
