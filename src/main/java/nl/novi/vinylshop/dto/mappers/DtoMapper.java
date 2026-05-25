package nl.novi.vinylshop.dto.mappers;

import nl.novi.vinylshop.entities.BaseEntity;

import java.util.List;

public class DtoMapper {

    public interface DTOMapper<RESPONSE, REQUEST , T extends BaseEntity> {
        RESPONSE mapToDto(T model);

        List<RESPONSE> mapToDto(List<T> models);

        T mapToEntity(REQUEST genreModel);
    }
}
