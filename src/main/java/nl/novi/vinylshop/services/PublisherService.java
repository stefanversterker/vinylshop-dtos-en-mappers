package nl.novi.vinylshop.services;

import nl.novi.vinylshop.dto.mappers.PublisherMapper;
import nl.novi.vinylshop.dto.publisher.PublisherRequestDto;
import nl.novi.vinylshop.dto.publisher.PublisherResponseDto;
import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.entities.PublisherEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.repositories.GenreRepository;
import nl.novi.vinylshop.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService{

    //Dependency injection van PublisherRepository en PublisherMapper
    private final PublisherRepository publisherRepository;
    private final PublisherMapper publisherMapper;

    public PublisherService(PublisherRepository publisherRepository,
                            PublisherMapper publisherMapper) {
        this.publisherRepository = publisherRepository;
        this.publisherMapper = publisherMapper;
    }

    public List<PublisherResponseDto> findAllPublishers() {
        return publisherMapper.mapToDto(publisherRepository.findAll());
    }
//Zoek Publisher in database op basis van id
    public PublisherResponseDto findPublisherById(Long id) {
        //Sla data op in dto en stuur naar client
        return publisherMapper.mapToDto(getPublisherById(id));
    }

    //Ontvang data van client
    public PublisherResponseDto createPublisher(PublisherRequestDto inputPublisher) {
        //Sla data op in entity
        PublisherEntity entity = publisherMapper.mapToEntity(inputPublisher);
        //Stuur data terug naar client
        return publisherMapper.mapToDto(publisherRepository.save(entity));
    }

    //Sla client input op in PublisherResponseDto
    public PublisherResponseDto updatePublisher(Long id, PublisherRequestDto input) {
        //Vind de publisher op basis van id
        PublisherEntity publisherEntity = getPublisherById(id);
        //Als publisherEntity niet null is, vervang de inhoud van de volgende velden
        if(publisherEntity != null){
            publisherEntity.setAddress(input.address());
            publisherEntity.setName(input.name());
            publisherEntity.setContactDetails(input.contactDetails());

            return publisherMapper.mapToDto(
                    publisherRepository.save(publisherEntity)
            );
        }
        return null; //aanpassen?
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    private PublisherEntity getPublisherById(Long id){
        return publisherRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException("Genre not found"));

//        De Optional.orElse() methode haalt de waarde uit de optional, of anders... Dit is één variant om met de Optional om te gaan.
        /*return publisherEntityOptional.orElse(null);*/
    }
}
