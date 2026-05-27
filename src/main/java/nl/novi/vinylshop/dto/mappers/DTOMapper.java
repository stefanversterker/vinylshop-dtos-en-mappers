package nl.novi.vinylshop.dto.mappers;

import nl.novi.vinylshop.entities.BaseEntity;

import java.util.List;

interface DTOMapper<RESPONSE, REQUEST , T extends BaseEntity> {
        RESPONSE mapToDto(T model);

        List<RESPONSE> mapToDto(List<T> models);

        T mapToEntity(REQUEST genreModel);
    }
