package vlad.way.order.service.controller.impl.v1;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlad.way.order.service.controller.OrderController;
import vlad.way.order.service.dto.OrderDTO;
import vlad.way.order.service.dto.request.OrderRequest;
import vlad.way.order.service.service.OrderService;


import java.util.UUID;

@RestController
@RequestMapping("/api/v1/order")
@AllArgsConstructor
@Slf4j
public class OrderControllerImpl implements OrderController {

    private final OrderService os;


    @Override
    public ResponseEntity<OrderDTO> getOrder(UUID orderId) {
        log.info("Get order with id: {}", orderId);
        return ResponseEntity.ok(os.getOrder(orderId));
    }

    @Override
    public ResponseEntity<OrderDTO> createOrder(OrderRequest order) {
        log.info("Start creat order");
        if(!os.isProductInInventory(order))
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(os.createOrder(order));
    }
}
