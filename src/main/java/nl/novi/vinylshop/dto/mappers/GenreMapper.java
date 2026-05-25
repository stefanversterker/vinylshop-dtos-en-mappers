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
        return null;
    }

    @Override
    public List<GenreResponseDto> mapToDto(List<GenreEntity> models) {
        return List.of();
    }

    @Override
    public GenreEntity mapToEntity(GenreRequestDto genreModel) {
        return null;
    }
}
