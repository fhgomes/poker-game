package org.fernando.gg.core.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.dto.GameDTO;
import org.fernando.gg.core.mappers.GameMapper;
import org.fernando.gg.core.repository.GameInMemoryManager;
import org.fernando.gg.core.services.contracts.IGameRoomManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
@AllArgsConstructor
public class GameManagerService implements IGameRoomManager {

	private final GameInMemoryManager gamesControl;
	private final GameMapper gameMapper;

	@Override
	public String createGame(String gameName) {
		String newGameRef = UUID.randomUUID().toString();
		gamesControl.insertGame(newGameRef, new GameRoom(newGameRef, gameName));
		return newGameRef;
	}

	public GameDTO retrieveGame(String gameRef) {
		Optional<GameRoom> gameByRef = gamesControl.retrieveGame(gameRef);
		GameRoom gameRoom = gameByRef
			.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Game not found"));

		return gameMapper.toDto(gameRoom);
	}

	@Override
	public void deleteGame(String gameRef) {
		gamesControl.removeGame(gameRef);
	}

	@Override
	public void joinGame(String gameRef, String playerName) {
		Optional<GameRoom> gameByRef = gamesControl.retrieveGame(gameRef);
		gameByRef.ifPresent(gameRoom -> gameRoom.joinPlayer(playerName));
	}

	@Override
	public void leaveGame(String gameRef, String playerName) {
		Optional<GameRoom> gameByRef = gamesControl.retrieveGame(gameRef);
		gameByRef.ifPresent(gameRoom -> gameRoom.removePlayer(playerName));
	}

	@Override
	public void addDeckToGame(String gameRef) {

	}

	public GameDTO retrieveGameByName(String gameName) {
		List<GameRoom> gameRooms = gamesControl.retrieveAllGames();
		GameRoom gameByName = gameRooms.stream()
			.filter(gameRoom -> gameRoom.getRoomName().equals(gameName))
			.findFirst()
			.orElseThrow(() -> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Game not found by name"));

		return gameMapper.toDto(gameByName);
	}
}
