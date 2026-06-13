package vlad.way.order.service.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.way.order.service.exception.OrderNotFountException;
import vlad.way.order.service.dto.OrderDTO;
import vlad.way.order.service.dto.request.OrderRequest;
import vlad.way.order.service.entity.Order;
import vlad.way.order.service.entity.OrderItem;
import vlad.way.order.service.entity.OrderStatus;
import vlad.way.order.service.repository.OrderRepository;
import vlad.way.order.service.service.OrderService;
import vlad.way.order.service.util.MapperOrder;

import java.math.BigDecimal;
import java.util.UUID;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class OrderServiceImpl implements OrderService {

    private final OrderRepository or;
    private final MapperOrder mo;

    @Override
    @Transactional
    public OrderDTO createOrder(OrderRequest orderDTO){
        Order order = mo.mapToOrder(orderDTO);
        order.setPrise(order.getItems().stream()
                .map(orderItem -> orderItem.getPrice()
                        .multiply(new BigDecimal(orderItem.getAmount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add));
        order.setStatus(OrderStatus.NEW);
        return mo.mapToOrderDTO(or.save(order));
    }

    @Override
    public OrderDTO getOrder(UUID id){
        return mo.mapToOrderDTO(or.findById(id)
                .orElseThrow(() -> new OrderNotFountException("Order not found with id")));
    }

    @Override
    public OrderDTO updateOrderStatus(UUID id, OrderStatus status){
        Order order = or.findById(id).orElseThrow(() -> new OrderNotFountException("Order not found with id"));
        order.setStatus(status);
        return mo.mapToOrderDTO(or.save(order));
    }

}
