package vlad.way.order.service.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlad.way.order.service.dto.OrderDTO;
import vlad.way.order.service.dto.request.OrderRequest;

import java.util.UUID;

@RestController
@RequestMapping("/api/order")
public interface OrderController {

    @GetMapping("/{orderId}")
    ResponseEntity<OrderDTO> getOrder(@PathParam("orderId") UUID orderId);

    @PostMapping
    ResponseEntity<OrderDTO> createOrder(@RequestBody OrderRequest order);
}
