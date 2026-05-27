package nl.novi.vinylshop.controllers;


import jakarta.validation.Valid;
import nl.novi.vinylshop.dto.genre.GenreRequestDto;
import nl.novi.vinylshop.dto.genre.GenreResponseDto;
import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.helpers.UrlHelper;
import nl.novi.vinylshop.services.GenreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//GET /genres - Haalt een lijst van alle genres op.
//GET /genres/{id} - Haalt een specifiek genre op basis van ID op.
//POST /genres - Creëert een nieuw genre.
//PUT /genres/{id} - Werkt een bestaand genre bij.
//DELETE /genres/{id} - Verwijdert een genre.


@RestController
@RequestMapping("/genres")
public class GenreController {

    private final GenreService genreService;
    private final UrlHelper urlHelper;

    public GenreController(GenreService genreService, UrlHelper urlHelper) {
        this.genreService = genreService;
        this.urlHelper = urlHelper;

    }

    @GetMapping
    public ResponseEntity<List<GenreResponseDto>> getAllGenres() {
        List<GenreResponseDto> genres = genreService.findAllGenres();
        return ResponseEntity.ok(genres);
    }


    @GetMapping("/{id}")
    public ResponseEntity<GenreResponseDto> getGenreById(@PathVariable Long id) {
        GenreResponseDto genre = genreService.findGenreById(id);
        return ResponseEntity.ok(genre);
    }

    @PostMapping
    //Ontvang data van client en sla dit op in genreModel object. @Valid checkt rules.
    public ResponseEntity<GenreResponseDto> createGenre(@RequestBody @Valid GenreRequestDto genreModel) {
        //Controller zegt tegen Service: Maak newGenre dto op basis van genreModel
        GenreResponseDto newGenre = genreService.createGenre(genreModel);
        //urlHelper geeft statuscode en header met datalocatie
        return ResponseEntity.created(urlHelper.getCurrentUrlWithId(newGenre.id())).body(newGenre);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GenreResponseDto> updateGenre(@PathVariable Long id, @RequestBody @Valid GenreRequestDto genreInput) {
        GenreResponseDto updatedGenre = genreService.updateGenre(id, genreInput);
        return ResponseEntity.ok(updatedGenre);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        genreService.deleteGenre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}


