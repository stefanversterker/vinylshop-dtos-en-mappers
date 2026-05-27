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
        return new PublisherResponseDto(
                model.getId(),
                model.getName(),
                model.getAddress(),
                model.getContactDetails()
        );
    }

    @Override
    public List<PublisherResponseDto> mapToDto(List<PublisherEntity> models) {
        return models.stream()
                .map(this::mapToDto)
                .toList();
    }

    @Override
    public PublisherEntity mapToEntity(PublisherRequestDto dto) {
        PublisherEntity entity = new PublisherEntity();
        entity.setName(dto.name());
        entity.setAddress(dto.address());
        entity.setContactDetails(dto.contactDetails());
        return entity;
    }
}
