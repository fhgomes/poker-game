package org.fernando.gg.core.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.domain.GamePlayer;
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
	public List<GamePlayer> listPlayersInGame(String gameRef) {
		GameRoom gameByRef = managerService.retrieveGame(gameRef);
		Comparator<GamePlayer> compareHands = Comparator.comparingInt(GamePlayer::getHandValue).reversed();
		List<GamePlayer> sortedByHand = new ArrayList<>(gameByRef.getPlayers());
		Collections.sort(sortedByHand, compareHands);

		return sortedByHand;
	}

	@Override
	public List<GameCard> listCardsOfPlayer(String gameRef, String playerName) {
		GameRoom gameByRef = managerService.retrieveGame(gameRef);
		return gameByRef.listCardsOfPlayer(playerName);
	}



}