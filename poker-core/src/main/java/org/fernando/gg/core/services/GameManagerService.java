package org.fernando.gg.core.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.repository.GameInMemoryManager;
import org.fernando.gg.core.services.contracts.IGameRoomManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
@AllArgsConstructor
public class GameManagerService implements IGameRoomManager {

	private final GameInMemoryManager gamesControl;

	@Override
	public String createGame(String gameName) {
		String newGameRef = UUID.randomUUID().toString();
		gamesControl.insertGame(newGameRef, new GameRoom(newGameRef, gameName));
		return newGameRef;
	}

	public GameRoom retrieveGame(String gameRef) {
		Optional<GameRoom> gameByRef = gamesControl.retrieveGame(gameRef);
		return handleExistsGame(gameByRef);
	}

	@Override
	public void deleteGame(String gameRef) {
		gamesControl.removeGame(gameRef);
	}


	public GameRoom retrieveGameByName(String gameName) {
		List<GameRoom> gameRooms = gamesControl.retrieveAllGames();
		Optional<GameRoom> gameByName = gameRooms.stream()
			.filter(gameRoom -> gameRoom.getRoomName().equals(gameName))
			.findFirst();

		return handleExistsGame(gameByName);
	}

	private GameRoom handleExistsGame(Optional<GameRoom> gameOpt) {
		return gameOpt
			.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Game not found"));
	}
}