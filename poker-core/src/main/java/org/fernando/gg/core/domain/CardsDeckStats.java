package org.fernando.gg.core.domain;

import java.util.HashMap;
import java.util.Map;

import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;

public class CardsDeckStats {

	private final Map<ECardSuits, Integer> totalBySuits;
	private final Map<String, Integer> totalBySuitAndValue;

	public CardsDeckStats() {
		this.totalBySuits = new HashMap<>();
		this.totalBySuitAndValue = new HashMap<>();
	}

	public int countBySuit(ECardSuits suit) {
		return getSuit(suit);
	}

	public int countByGameCard(ECardSuits suit, EPokerCardValues value) {
		return getSuitAndValue(getHashCardKey(suit, value));
	}
	public void addDeck(CardsDeck cardsDeck) {
		cardsDeck.getCards().forEach(this::addCard);
	}

	public void addCard(GameCard card) {
		Integer currentSuit = getSuit(card.getSuit());
		updateSuit(card, currentSuit + 1);

		String hashKey = getHashCardKey(card.getSuit(), card.getValue());
		Integer currentSuitAndValue = getSuitAndValue(hashKey);
		updateSuitAndValue(hashKey, currentSuitAndValue + 1);
	}

	public void removeCard(GameCard card) {
		Integer currentSuit = getSuit(card.getSuit());
		updateSuit(card, currentSuit - 1);

		String hashKey = getHashCardKey(card.getSuit(), card.getValue());
		Integer currentSuitAndValue = getSuitAndValue(hashKey);
		updateSuitAndValue(hashKey, currentSuitAndValue - 1);
	}

	private static String getHashCardKey(ECardSuits suit, EPokerCardValues value) {
		String suitVisualKey = suit.getVisualKey();
		String valueVisualKey = value.getVisualKey();
		String hashKey = suitVisualKey.concat("-").concat(valueVisualKey);
		return hashKey;
	}

	private Integer getSuit(ECardSuits suit) {
		return totalBySuits.getOrDefault(suit, 0);
	}

	private Integer getSuitAndValue(String hashKey) {
		return totalBySuitAndValue.getOrDefault(hashKey, 0);
	}

	private Integer updateSuit(GameCard card, int newCount) {
		int newCountSafe = Math.max(newCount, 0);
		return totalBySuits.put(card.getSuit(), newCountSafe);
	}

	private Integer updateSuitAndValue(String hashKey, int newCount) {
		int newCountSafe = Math.max(newCount, 0);
		return totalBySuitAndValue.put(hashKey, newCountSafe);
	}


}
