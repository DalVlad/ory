package vlad.way.order.service.dto;

import vlad.way.order.service.entity.OrderItem;
import vlad.way.order.service.entity.OrderStatus;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public record OrderDTO(

        UUID id,
        BigDecimal prise,
        List<OrderItemDTO> items,
        OrderStatus status

) {
}
