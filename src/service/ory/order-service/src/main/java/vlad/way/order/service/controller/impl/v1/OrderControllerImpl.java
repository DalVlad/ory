package vlad.way.order.service.controller.impl.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import vlad.way.order.service.controller.OrderController;
import vlad.way.order.service.dto.OrderDTO;
import vlad.way.order.service.dto.request.OrderRequest;
import vlad.way.order.service.service.OrderService;


import java.util.UUID;

@RestController("/api/v1/order")
@AllArgsConstructor
public class OrderControllerImpl implements OrderController {

    private final OrderService os;


    @Override
    public ResponseEntity<OrderDTO> getOrder(UUID orderId) {
        return ResponseEntity.ok(os.getOrder(orderId));
    }

    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderRequest order) {
        return ResponseEntity.ok(os.createOrder(order));
    }
}
