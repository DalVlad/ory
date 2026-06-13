package vlad.way.inventory.service.dto;

import jakarta.validation.constraints.Min;

import java.util.UUID;

public record ProductDTO(

        UUID id,

        @Min(0L)
        long amount

) {
}
