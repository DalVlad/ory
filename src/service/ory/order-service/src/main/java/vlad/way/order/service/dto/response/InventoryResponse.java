package vlad.way.order.service.dto.response;

import jakarta.validation.constraints.Min;

import java.util.UUID;

public record InventoryResponse(

        UUID productId,

        @Min(0L)
        long amount

) {
}