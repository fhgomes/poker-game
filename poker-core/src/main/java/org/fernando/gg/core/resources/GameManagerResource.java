package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.dto.GameDTO;
import org.fernando.gg.core.services.GameManagerService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/game")
public class GameManagerResource {

	private final GameManagerService managerService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public String createGame(@RequestBody String gameName) {
		return managerService.createGame(gameName);
	}

	@GetMapping("/{gameRef}")
	public GameDTO getGame(@PathVariable String gameRef) {
		return managerService.retrieveGame(gameRef);
	}

	@DeleteMapping("/{gameRef}")
	public void deleteGame(@PathVariable String gameRef) {
		managerService.deleteGame(gameRef);
	}

}
