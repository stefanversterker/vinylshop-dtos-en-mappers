package nl.novi.vinylshop.dto.mappers;

import nl.novi.vinylshop.dto.genre.GenreRequestDto;
import nl.novi.vinylshop.dto.genre.GenreResponseDto;
import nl.novi.vinylshop.entities.GenreEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GenreMapper implements DTOMapper<
        GenreResponseDto,
        GenreRequestDto,
        GenreEntity> {

    @Override
    public GenreResponseDto mapToDto(GenreEntity model) {
        return new GenreResponseDto(
                model.getId(),
                model.getName(),
                model.getDescription()
        );
    }

    @Override
    public List<GenreResponseDto> mapToDto(List<GenreEntity> models) {
        return models.stream()
        .map(model -> mapToDto(model))
                .toList();
    }

    @Override
    public GenreEntity mapToEntity(GenreRequestDto dto) {
        GenreEntity entity = new GenreEntity();
        entity.setName(dto.name());
        entity.setDescription(dto.description());
        return entity;
    }
}
