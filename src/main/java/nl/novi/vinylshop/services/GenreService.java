package nl.novi.vinylshop.services;

import nl.novi.vinylshop.entities.GenreEntity;
import nl.novi.vinylshop.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {

    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }


    public List<GenreEntity> findAllGenres() {
        return genreRepository.findAll();
    }


    public GenreEntity findGenreById(Long id) {
       return getGenreById(id);
    }


    public GenreEntity createGenre(GenreEntity input) {
        return genreRepository.save(input);
    }


    public GenreEntity updateGenre(Long id, GenreEntity input) {
        GenreEntity genre = getGenreById(id);
        if(genre != null) {
            genre.setDescription(input.getDescription());
            genre.setName(input.getName());
            return genreRepository.save(genre);
        }

        return null;
    }


    public void deleteGenre(Long id) {
        genreRepository.deleteById(id);
    }

    private GenreEntity getGenreById(Long id){
        Optional<GenreEntity> genreEntityOptional = genreRepository.findById(id);

//        Een if-statement waar je expliciet de Optional.isPresent() of Optional.isEmpty() checkt, is één variant om met de optional om te gaan.
        if(genreEntityOptional.isPresent()){
            return genreEntityOptional.get();
        } else {
            return null;
        }
    }
}
