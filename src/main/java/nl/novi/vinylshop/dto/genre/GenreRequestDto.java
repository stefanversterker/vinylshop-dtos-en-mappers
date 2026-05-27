package nl.novi.vinylshop.dto.genre;

//springboot starter validation dependency
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record GenreRequestDto(
        Long id,

        @NotNull(message = "Genre mag niet null zijn")
        @Size(min = 2, max = 100, message = "Het aantal karakters moet tussen de 2 en 100 liggen")
        String name,

        @Size(max = 255, message = "Het maximum aantal karakters is 255")
        String description
) {}
