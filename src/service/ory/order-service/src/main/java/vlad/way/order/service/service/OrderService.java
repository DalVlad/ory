package vlad.way.order.service.service;

import vlad.way.order.service.dto.OrderDTO;
import vlad.way.order.service.dto.request.OrderRequest;
import vlad.way.order.service.entity.OrderStatus;

import java.util.UUID;

public interface OrderService {

    OrderDTO createOrder(OrderRequest orderDTO);
    OrderDTO getOrder(UUID id);
    OrderDTO updateOrderStatus(UUID id, OrderStatus status);
    boolean isProductInInventory(OrderRequest orderDTO);

}
