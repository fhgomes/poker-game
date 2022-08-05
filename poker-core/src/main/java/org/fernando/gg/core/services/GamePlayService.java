package org.fernando.gg.core.services;

import java.util.List;
import java.util.Random;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.DeckFactory;
import org.fernando.gg.core.domain.CardsDeck;
import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.domain.GameDeckShoe;
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
	public List<GameCard> dealCards(String gameRef, String playerName, int cardsRequest) {
		GameRoom gameByRef = gameManager.retrieveGame(gameRef);
		return gameByRef.dealCards(playerName, cardsRequest);
	}

	@Override
	public void shuffleCards(String gameRef) {
		GameRoom gameByRef = gameManager.retrieveGame(gameRef);
		GameDeckShoe gameDeckShoe = gameByRef.getGameDeckShoe();
		gameDeckShoe.shufflePosition();

	}

}