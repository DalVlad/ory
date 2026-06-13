package vlad.way.inventory.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vlad.way.inventory.service.entity.Product;


import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
