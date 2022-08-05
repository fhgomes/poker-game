package org.fernando.gg.core.mappers;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 @param <D> - DTO type parameter.
 @param <E> - Entity type parameter.
 */

public interface EntityMapper<D, E> extends DTOMapper {

    E toEntity(D dto);

    List<E> toEntity(List<D> dtoList);
}