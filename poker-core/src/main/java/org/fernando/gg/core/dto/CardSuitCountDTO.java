package org.fernando.gg.core.dto;

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
public class CardSuitCountDTO {

	@JsonProperty("countHearts")
	private int countHearts;

	@JsonProperty("countSpades")
	private int countSpades;

	@JsonProperty("countClubs")
	private int countClubs;

	@JsonProperty("countDiamonds")
	private int countDiamonds;



}
