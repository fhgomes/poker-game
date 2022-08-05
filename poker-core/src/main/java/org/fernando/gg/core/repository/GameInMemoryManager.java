package org.fernando.gg.core.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.fernando.gg.core.domain.GameRoom;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpServerErrorException;

@Component
@Scope("singleton")
public class GameInMemoryManager {

	private final Map<String, GameRoom> currentGames;

	public GameInMemoryManager() {
		this.currentGames = new HashMap<>();
	}

	public void insertGame(String ref, GameRoom newGame) {
		currentGames.values().stream()
			.filter(game -> game.getRoomName().equals(newGame.getRoomName()))
			.findFirst()
			.ifPresent(player -> {
				throw new HttpServerErrorException(HttpStatus.CONFLICT, "GameRoom with this name already exists");
			});
		currentGames.put(ref, newGame);
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
