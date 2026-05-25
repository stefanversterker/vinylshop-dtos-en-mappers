package nl.novi.vinylshop.dto.mappers;

import nl.novi.vinylshop.dto.publisher.PublisherRequestDto;
import nl.novi.vinylshop.dto.publisher.PublisherResponseDto;
import nl.novi.vinylshop.entities.PublisherEntity;
import org.springframework.stereotype.Component;

@Component
public class PublisherMapper implements DtoMapper<
    PublisherResponseDto,
    PublisherRequestDto,
        PublisherEntity>{



}
