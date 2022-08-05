package org.fernando.gg.core.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpServerErrorException;

@Getter
public class GameRoom {
	private final String gameRef;
	private final String roomName;
	private final List<GamePlayer> players = new ArrayList<>();
	private final GameDeckShoe gameDeckShoe;
	private final CardsDeckStats cardsDeckStats;

	public GameRoom(String gameRef, String roomName) {
		this.gameRef = gameRef;
		this.roomName = roomName;
		this.gameDeckShoe = new GameDeckShoe();
		this.cardsDeckStats = new CardsDeckStats();
	}

	public void joinPlayer(String playerName) {
		players.add(new GamePlayer(playerName));
		//TODO not allow to joing after start
		//TODO not allow to joing same playername
	}

	public void removePlayer(String playerName) {
		players.removeIf(playerByName(playerName));
		//TODO what to do if a player quite and the gaming is on going?
	}

	public void addDeck(CardsDeck cardsDeck) {
		gameDeckShoe.addDeck(cardsDeck);
		cardsDeckStats.proccessDeck(cardsDeck);
	}

	public List<GameCard> dealCards(String playerName, int cardsRequest) {
		GamePlayer playerByName = players.stream().filter(playerByName(playerName))
			.findFirst()
			.orElseThrow(()-> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Player not found in game"));

		List<GameCard> dealtCards = new ArrayList<>();
		for (int i = 0; i < cardsRequest; i++) {
			Optional<GameCard> cardCandidate = gameDeckShoe.retrieveCard();
			cardCandidate.ifPresent(card -> {
				dealtCards.add(card);
				playerByName.receiveCard(card);
				cardsDeckStats.removeCard(card);
			});
		}
		return dealtCards;
	}

	public List<GameCard> listCardsOfPlayer(String playerName) {
		GamePlayer playerByName = players.stream().filter(playerByName(playerName))
			.findFirst()
			.orElseThrow(()-> new HttpServerErrorException(HttpStatus.NOT_FOUND, "Player not found in game"));

		return playerByName.getHandCards();
	}

	Predicate<GamePlayer> playerByName(String playerName) {
		return player -> player.getPlayerName().equals(playerName);
	}


}
