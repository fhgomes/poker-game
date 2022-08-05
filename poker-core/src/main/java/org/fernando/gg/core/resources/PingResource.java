package org.fernando.gg.core.resources;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ping")
public class PingResource {

	@GetMapping
	public String doPing() {
		return "Pong";
	}

}
