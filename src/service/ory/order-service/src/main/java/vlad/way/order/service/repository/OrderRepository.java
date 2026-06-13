package vlad.way.order.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlad.way.order.service.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}