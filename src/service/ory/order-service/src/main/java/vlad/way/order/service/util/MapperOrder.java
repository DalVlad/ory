package vlad.way.order.service.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import vlad.way.order.service.dto.OrderDTO;
import vlad.way.order.service.dto.OrderItemDTO;
import vlad.way.order.service.dto.request.OrderRequest;
import vlad.way.order.service.entity.Order;
import vlad.way.order.service.entity.OrderItem;

@Component
@RequiredArgsConstructor
public class MapperOrder {

    public Order mapToOrder(OrderDTO dto){
        return new Order(dto.id(), dto.prise(),
                dto.items().stream().map(this::mapToOrderItem).toList(), dto.status());
    }

    public Order mapToOrder(OrderRequest dto){
        Order order = new Order();
        order.setItems(dto.items().stream().map(this::mapToOrderItem).toList());
        return order;
    }

    public OrderItem mapToOrderItem(OrderItemDTO dto){
        OrderItem orderItem = new OrderItem();
        orderItem.setProductId(dto.productId());
        orderItem.setAmount(dto.amount());
        orderItem.setPrice(dto.price());
        return orderItem;
    }

    public OrderDTO mapToOrderDTO(Order o){
        return new OrderDTO(o.getId(), o.getPrise(),
                o.getItems().stream().map(this::mapToOrderItemDTO).toList(), o.getStatus());
    }

    public OrderItemDTO mapToOrderItemDTO(OrderItem o){
        return new OrderItemDTO(o.getProductId(), o.getPrice(), o.getAmount());
    }

}
