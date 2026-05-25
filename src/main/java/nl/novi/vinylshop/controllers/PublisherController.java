package nl.novi.vinylshop.controllers;


import nl.novi.vinylshop.dto.publisher.PublisherRequestDto;
import nl.novi.vinylshop.dto.publisher.PublisherResponseDto;
import nl.novi.vinylshop.entities.PublisherEntity;
import nl.novi.vinylshop.helpers.UrlHelper;
import nl.novi.vinylshop.services.PublisherService;
import nl.novi.vinylshop.services.PublisherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /publishers - Haalt een lijst van alle publishers op.
//GET /publishers/{id} - Haalt een specifiek publisher op basis van ID op.
//POST /publishers - Creëert een nieuw publisher.
//PUT /publishers/{id} - Werkt een bestaand publisher bij.
//DELETE /publishers/{id} - Verwijdert een publisher.


@RestController
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;
    private final UrlHelper urlHelper;

    public PublisherController(PublisherService publisherService, UrlHelper urlHelper) {
        this.publisherService = publisherService;
        this.urlHelper = urlHelper;

    }

    @GetMapping
    public ResponseEntity<List<PublisherResponseDto>> getAllPublishers() {
        var publishers = publisherService.findAllPublishers();
        return ResponseEntity.ok(publishers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> getPublisherById(@PathVariable Long id) {
        var publisher = publisherService.findPublisherById(id);
        return new ResponseEntity<>(publisher, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PublisherResponseDto> createPublisher(@RequestBody PublisherRequestDto publisherInput) {
        var newPublisher = publisherService.createPublisher(publisherInput);
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newPublisher.getId())).body(newPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PublisherResponseDto> updatePublisher(@PathVariable Long id, @RequestBody PublisherRequestDto publisherInput) {
        var updatedPublisher = publisherService.updatePublisher(id, publisherInput);
        return new ResponseEntity<>(updatedPublisher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


