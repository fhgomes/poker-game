package org.fernando.gg.core.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import lombok.AllArgsConstructor;
import org.fernando.gg.core.DeckFactory;
import org.fernando.gg.core.domain.CardsDeckStats;
import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.dto.CardSuitAndValueCountDTO;
import org.fernando.gg.core.dto.CardSuitCountDTO;
import org.fernando.gg.core.dto.CardValueCountDTO;
import org.fernando.gg.core.services.contracts.IGameStatsManager;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GameStatsService implements IGameStatsManager {

	private final GameManagerService gameManager;
	private final DeckFactory deckFactory;

	@Override
	public CardSuitCountDTO countCardsLeftBySuit(String gameRef) {
		GameRoom gameByRef = gameManager.retrieveGame(gameRef);
		CardsDeckStats deckStats = gameByRef.getCardsDeckStats();

		return CardSuitCountDTO.builder()
			.countHearts(deckStats.countBySuit(ECardSuits.HEART))
			.countSpades(deckStats.countBySuit(ECardSuits.SPADE))
			.countClubs(deckStats.countBySuit(ECardSuits.CLUB))
			.countDiamonds(deckStats.countBySuit(ECardSuits.DIAMOND))
			.build();
	}

	@Override
	public CardSuitAndValueCountDTO listCardsLeft(String gameRef) {
		GameRoom gameByRef = gameManager.retrieveGame(gameRef);
		CardsDeckStats deckStats = gameByRef.getCardsDeckStats();

		return CardSuitAndValueCountDTO.builder()
			.countHearts(listCountOf(ECardSuits.HEART, deckStats))
			.countSpades(listCountOf(ECardSuits.SPADE, deckStats))
			.countClubs(listCountOf(ECardSuits.CLUB, deckStats))
			.countDiamonds(listCountOf(ECardSuits.DIAMOND, deckStats))
			.build();
	}

	private List<CardValueCountDTO> listCountOf(ECardSuits suit, CardsDeckStats deckStats) {
		List<GameCard> gameCards = deckFactory.listCardsBySuit(suit);
		Comparator<GameCard> compareCardValue = Comparator.comparingInt(GameCard::getCardValue).reversed();
		Collections.sort(gameCards, compareCardValue);
		List<CardValueCountDTO> suitGroup = new ArrayList<>();
		gameCards.forEach(card -> addCountToGroup(suitGroup, deckStats, card));
		return suitGroup;
	}

	private void addCountToGroup(List<CardValueCountDTO> suitGroup, CardsDeckStats deckStats, GameCard card) {
		String visualKey = card.getValue().getVisualKey();
		int count = deckStats.countByGameCard(card.getSuit(), card.getValue());
		suitGroup.add(new CardValueCountDTO(visualKey, count));
	}

}