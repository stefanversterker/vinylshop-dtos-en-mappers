package nl.novi.vinylshop.dto.mappers;


import nl.novi.vinylshop.dto.publisher.PublisherRequestDto;
import nl.novi.vinylshop.dto.publisher.PublisherResponseDto;
import nl.novi.vinylshop.entities.PublisherEntity;
import org.springframework.stereotype.Component;
import nl.novi.vinylshop.dto.mappers.DTOMapper;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Component
public class PublisherMapper implements DTOMapper<
    PublisherResponseDto,
    PublisherRequestDto,
        PublisherEntity> {

    @Override
    public PublisherResponseDto mapToDto(PublisherEntity model) {
        return null;
    }

    @Override
    public List<PublisherResponseDto> mapToDto(List<PublisherEntity> models) {
        return List.of();
    }

    @Override
    public PublisherEntity mapToEntity(PublisherRequestDto genreModel) {
        return null;
    }
}
