package nl.novi.vinylshop.services;

import nl.novi.vinylshop.dto.publisher.PublisherRequestDto;
import nl.novi.vinylshop.dto.publisher.PublisherResponseDto;
import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.entities.PublisherEntity;
import nl.novi.vinylshop.repositories.GenreRepository;
import nl.novi.vinylshop.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PublisherService{

    private final PublisherRepository publisherRepository;

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public List<PublisherResponseDto> findAllPublishers() {
        return publisherRepository.findAll();
    }

    public PublisherResponseDto findPublisherById(Long id) {
        return getPublisherById(id);
    }

    public PublisherResponseDto createPublisher(PublisherRequestDto inputPublisher) {
        return publisherRepository.save(inputPublisher);
    }

    public PublisherResponseDto updatePublisher(Long id, PublisherRequestDto input) {
        PublisherEntity publisherEntity = getPublisherById(id);
        if(publisherEntity != null){
            publisherEntity.setAddress(input.getAddress());
            publisherEntity.setName(input.getName());
            publisherEntity.setContactDetails(input.getContactDetails());
            return publisherRepository.save(publisherEntity);
        }
        return null; //aanpassen
    }

    public void deletePublisher(Long id) {
        publisherRepository.deleteById(id);
    }

    private PublisherEntity getPublisherById(Long id){
        Optional<PublisherEntity> publisherEntityOptional = publisherRepository.findById(id);

//        De Optional.orElse() methode haalt de waarde uit de optional, of anders... Dit is één variant om met de Optional om te gaan.
        return publisherEntityOptional.orElse(null);
    }
}
