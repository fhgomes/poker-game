package org.fernando.gg.core.services;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.DeckFactory;
import org.fernando.gg.core.domain.CardsDeck;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.services.contracts.IGamePlayManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GamePlayService implements IGamePlayManager {

	private final GameManagerService gameManager;
	private final DeckFactory deckFactory;

	@Override
	public void addDeckToGame(String gameRef) {
		GameRoom gameByRef = gameManager.retrieveGame(gameRef);
		CardsDeck cardsDeck = deckFactory.createPokerDeck();
		gameByRef.addDeck(cardsDeck);
	}

	@Override
	public void dealCards(String gameRef, String playerName, int cardsRequest) {
		GameRoom gameByRef = gameManager.retrieveGame(gameRef);

	}

	@Override
	public void shuffleCards(String gameRef) {
		//do nothing for while
	}

}