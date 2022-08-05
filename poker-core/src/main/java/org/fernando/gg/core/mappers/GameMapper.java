package org.fernando.gg.core.mappers;

import org.fernando.gg.core.domain.GamePlayer;
import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.dto.GameDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface GameMapper extends DTOMapper<GameDTO, GameRoom> {
	default String fromGamePlayer(GamePlayer player) {
		return player == null ? null : player.getPlayerName();
	}
}