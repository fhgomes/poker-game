package org.fernando.gg.core.mappers;

import java.util.List;

/**
 * Contract for a generic dto to entity mapper.
 @param <D> - DTO type parameter.
 @param <E> - Entity type parameter.
 */

public interface DTOMapper<D, E> {

    D toDto(E entity);
    List <D> toDto(List<E> entityList);
}