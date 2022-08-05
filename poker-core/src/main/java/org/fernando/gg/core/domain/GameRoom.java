package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class GameRoom {
	private final String gameRef;
	private final String roomName;
	private final List<GamePlayer> players = new ArrayList<>();
	private final GameDeckShoe gameDeckShoe;
	private final CardsDeckStats cardsDeckStats;

	public GameRoom(String gameRef, String roomName) {
		this.gameRef = gameRef;
		this.roomName = roomName;
		this.gameDeckShoe = new GameDeckShoe();
		this.cardsDeckStats = new CardsDeckStats();
	}

	public void joinPlayer(String playerName) {
		players.add(new GamePlayer(playerName));
		//TODO not allow to joing after start
		//TODO not allow to joing same playername
	}

	public void removePlayer(String playerName) {
		players.removeIf(player -> player.getPlayerName().equals(playerName));
		//TODO what to do if a player quite and the gaming is on going?
	}

	public void addDeck(CardsDeck cardsDeck) {
		gameDeckShoe.addDeck(cardsDeck);
		cardsDeckStats.addDeck(cardsDeck);
	}
}
