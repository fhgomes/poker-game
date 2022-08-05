package org.fernando.gg.core.resources;

import java.util.List;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.dto.DealCardsDTO;
import org.fernando.gg.core.dto.GameCardDTO;
import org.fernando.gg.core.mappers.GameCardMapper;
import org.fernando.gg.core.services.GamePlayService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game/{gameRef}/play")
public class GamePlayResource {

	private final GamePlayService playService;
	private final GameCardMapper gameCardMapper;

	@PostMapping("decks/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPokerDeck(
		@PathVariable("gameRef") String gameRef) {
		playService.addDeckToGame(gameRef);
	}

	@PostMapping("decks/shuffle")
	public void shuffleCards(
		@PathVariable("gameRef") String gameRef) {
		playService.shuffleCards(gameRef);
	}

	@PostMapping("decks/deal")
	public List<GameCardDTO> dealCards(
		@PathVariable("gameRef") String gameRef,
		@RequestBody DealCardsDTO dealCards) {
		List<GameCard> cards = playService.dealCards(gameRef, dealCards.getPlayerName(), dealCards.getQuantity());
		return gameCardMapper.toDto(cards);
	}

}
