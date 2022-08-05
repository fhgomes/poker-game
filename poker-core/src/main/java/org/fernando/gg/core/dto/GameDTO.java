package org.fernando.gg.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameDTO {

	@JsonProperty("gameRef")
	private String gameRef;

	@JsonProperty("roomName")
	private String roomName;

	@JsonProperty("players")
	private List<String> players;
}
