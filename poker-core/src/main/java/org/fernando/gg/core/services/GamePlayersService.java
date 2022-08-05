package org.fernando.gg.core.services;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.services.contracts.IGamePlayersManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GamePlayersService implements IGamePlayersManager {

	private final GameManagerService managerService;
	@Override
	public void joinGame(String gameRef, String playerName) {
		GameRoom gameByRef = managerService.retrieveGame(gameRef);
		gameByRef.joinPlayer(playerName);
	}

	@Override
	public void leaveGame(String gameRef, String playerName) {
		GameRoom gameByRef = managerService.retrieveGame(gameRef);
		gameByRef.removePlayer(playerName);
	}

	@Override
	public void listCardsOfPlayer(String gameRef, String playerName) {

	}

	@Override
	public void listPlayersInGame(String gameRef) {

	}

}