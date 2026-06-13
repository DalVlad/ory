package vlad.way.order.service.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemDTO(

        UUID productId,
        BigDecimal price,
        long amount

) {

}
