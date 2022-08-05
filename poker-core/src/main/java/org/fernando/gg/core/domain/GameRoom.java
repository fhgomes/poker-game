package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameRoom {
	private final String gameRef;
	private final String roomName;
	private final List<String> players = new ArrayList<>();

	public void joinPlayer(String playerName) {
		players.add(playerName);
	}

	public void removePlayer(String playerName) {
		players.remove(playerName);
	}
}
