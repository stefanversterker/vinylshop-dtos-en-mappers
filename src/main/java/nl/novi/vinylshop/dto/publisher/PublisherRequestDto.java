package nl.novi.vinylshop.dto.publisher;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record PublisherRequestDto(
        Long id,

        @NotNull(message = "Publisher mag niet null zijn")
        @Size(min = 2, max = 100, message = "Het aantal karakters moet tussen de 2 en 100 liggen")
        String name,
        String address,
        String contactDetails

)
{}

