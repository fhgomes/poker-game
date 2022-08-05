package org.fernando.gg.core.mappers;

import org.fernando.gg.core.domain.GamePlayer;
import org.fernando.gg.core.dto.GamePlayerHandDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GamePlayerHandMapper extends DTOMapper<GamePlayerHandDTO, GamePlayer> {

}