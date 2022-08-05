package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.services.GameManagerService;
import org.fernando.gg.core.services.GamePlayersService;
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
@RequestMapping("/api/game/{gameRef}/players")
public class GamePlayersManagerResource {

	private final GamePlayersService playersService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void joinGame(
		@PathVariable("gameRef") String gameRef,
		@RequestBody String playerName) {
		playersService.joinGame(gameRef, playerName);
	}

	@DeleteMapping("/{playerName}")
	public void leaveGame(
		@PathVariable("gameRef") String gameRef,
		@PathVariable("playerName") String playerName) {
		playersService.leaveGame(gameRef, playerName);
	}


}
