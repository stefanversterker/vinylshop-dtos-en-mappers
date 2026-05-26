package nl.novi.vinylshop.services;

import nl.novi.vinylshop.dto.genre.GenreResponseDto;
import nl.novi.vinylshop.dto.mappers.GenreMapper;
import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.exceptions.RecordNotFoundException;
import nl.novi.vinylshop.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import nl.novi.vinylshop.dto.genre.GenreRequestDto;
import nl.novi.vinylshop.dto.genre.GenreResponseDto;

@Service
public class GenreService {

    private final GenreRepository genreRepository;
    private final GenreMapper genreMapper;


    public GenreService(GenreRepository genreRepository,
                        GenreMapper genreMapper) {
        this.genreRepository = genreRepository;
        this.genreMapper = genreMapper;
    }


    public List<GenreResponseDto> findAllGenres() {
        return genreMapper.mapToDto(genreRepository.findAll());
    }


    public GenreResponseDto findGenreById(Long id) {
       return genreMapper.mapToDto(getGenreById(id));
    }


    public GenreResponseDto createGenre(GenreRequestDto input) {
        GenreEntity entity = genreMapper.mapToEntity(input);
        return genreMapper.mapToDto(genreRepository.save(entity));
    }


    public GenreResponseDto updateGenre(Long id, GenreRequestDto input) {
        GenreEntity genreEntity = getGenreById(id);

        if(genreEntity != null) {
            genreEntity.setDescription(input.description());
            genreEntity.setName(input.name());

            return genreMapper.mapToDto(
                    genreRepository.save(genreEntity)
            );
        }

        return null;
    }


    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    private GenreEntity getGenreById(Long id){
        return genreRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException("Genre not found"));

//        Een if-statement waar je expliciet de Optional.isPresent() of Optional.isEmpty() checkt, is één variant om met de optional om te gaan.
        /*if(genreEntityOptional.isPresent()){
            return genreEntityOptional.get();
        } else {
            return null;
        }*/
    }
}
