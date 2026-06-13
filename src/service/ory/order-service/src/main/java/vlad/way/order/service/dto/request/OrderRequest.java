package vlad.way.order.service.dto.request;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import vlad.way.order.service.dto.OrderItemDTO;

import java.util.List;

public record OrderRequest(

        @NotNull
        @NotEmpty
        List<OrderItemDTO> items

) {
}
