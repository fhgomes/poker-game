package org.fernando.gg.core.mappers;

import org.fernando.gg.core.domain.GameRoom;
import org.fernando.gg.core.dto.GameDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GameMapper extends DTOMapper<GameDTO, GameRoom> {

}