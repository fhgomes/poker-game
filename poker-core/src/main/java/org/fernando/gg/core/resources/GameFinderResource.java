package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.fernando.gg.core.dto.GameDTO;
import org.fernando.gg.core.services.GameManagerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/gamefinder")
public class GameFinderResource {

	private final GameManagerService managerService;

	@GetMapping
	public GameDTO findGame(
		@RequestParam(value = "gameName", defaultValue = "") String gameName) {
		return managerService.retrieveGameByName(gameName);
	}

}
