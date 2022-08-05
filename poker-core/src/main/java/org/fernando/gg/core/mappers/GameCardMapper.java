package org.fernando.gg.core.mappers;

import org.fernando.gg.core.domain.GameCard;
import org.fernando.gg.core.domain.fixed.ECardSuits;
import org.fernando.gg.core.domain.fixed.EPokerCardValues;
import org.fernando.gg.core.dto.GameCardDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameCardMapper extends DTOMapper<GameCardDTO, GameCard> {
	default String fromECardSuits(ECardSuits suit) {
		return suit == null ? null : suit.getVisualName();
	}

	default String fromEPokerCardValues(EPokerCardValues value) {
		return value == null ? null : value.getVisualName();
	}
}