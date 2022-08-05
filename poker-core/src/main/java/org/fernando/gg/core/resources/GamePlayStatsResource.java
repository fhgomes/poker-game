package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.dto.CardSuitAndValueCountDTO;
import org.fernando.gg.core.dto.CardSuitCountDTO;
import org.fernando.gg.core.services.GameStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game/{gameRef}/stats")
public class GamePlayStatsResource {

	private final GameStatsService gameStatsService;

	@GetMapping("/suits")
	public CardSuitCountDTO countBySuit(
		@PathVariable("gameRef") String gameRef) {
		return gameStatsService.countCardsLeftBySuit(gameRef);
	}

	@GetMapping
	public CardSuitAndValueCountDTO countAll(
		@PathVariable("gameRef") String gameRef) {
		return gameStatsService.listCardsLeft(gameRef);
	}

}