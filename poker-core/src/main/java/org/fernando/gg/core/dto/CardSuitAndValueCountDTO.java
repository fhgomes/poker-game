package org.fernando.gg.core.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardSuitAndValueCountDTO {

	@JsonProperty("countHearts")
	private List<CardValueCountDTO> countHearts;

	@JsonProperty("countSpades")
	private List<CardValueCountDTO> countSpades;

	@JsonProperty("countClubs")
	private List<CardValueCountDTO> countClubs;

	@JsonProperty("countDiamonds")
	private List<CardValueCountDTO> countDiamonds;

}