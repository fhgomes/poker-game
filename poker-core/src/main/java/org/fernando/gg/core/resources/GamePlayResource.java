package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.services.GamePlayService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game/{gameRef}/play")
public class GamePlayResource {

	private final GamePlayService playService;

	@PostMapping("decks/add")
	@ResponseStatus(HttpStatus.CREATED)
	public void addPokerDeck(
		@PathVariable("gameRef") String gameRef) {
		playService.addDeckToGame(gameRef);
	}

}
