package org.fernando.gg.core.services;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.services.contracts.IGamePlayManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GamePlayService implements IGamePlayManager {

	private final GameManagerService gamesControl;

	@Override
	public void addDeckToGame(String gameRef) {

	}

	@Override
	public int countCardsLeftBySuit(String gameRef) {
		return 0;
	}

	@Override
	public int listCardsLeft(String gameRef) {
		return 0;
	}

	@Override
	public void shuffleShoe(String gameRef) {

	}

	@Override
	public void dealCards(String gameRef, String playerName, int cardsRequest) {

	}
}