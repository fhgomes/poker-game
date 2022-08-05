package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.services.GameManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game/{gameRef}/decks")
public class GameDecksManagerResource {

	private final GameManagerService managerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void addPokerDeck(
		@PathVariable("gameRef") String gameRef) {
		managerService.addDeckToGame(gameRef);
	}

}
