package org.fernando.gg.core.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.fernando.gg.core.domain.GameRoom;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("singleton")
public class GameInMemoryManager {

	private final Map<String, GameRoom> currentGames;

	public GameInMemoryManager() {
		this.currentGames = new HashMap<>();
	}

	public void insertGame(String ref, GameRoom game) {
		currentGames.put(ref, game);
	}

	public void removeGame(String gameRef) {
		currentGames.remove(gameRef);
	}

	public Optional<GameRoom> retrieveGame(String gameRef) {
		return Optional.ofNullable(currentGames.get(gameRef));
	}

	public List<GameRoom> retrieveAllGames() {
		return currentGames.values().stream().collect(Collectors.toUnmodifiableList());
	}
}
