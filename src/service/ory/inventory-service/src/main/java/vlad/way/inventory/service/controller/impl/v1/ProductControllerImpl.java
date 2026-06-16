package vlad.way.inventory.service.controller.impl.v1;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlad.way.inventory.service.controller.ProductController;
import vlad.way.inventory.service.dto.ProductDTO;
import vlad.way.inventory.service.service.ProductService;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/inventory")
@AllArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService ps;

    @Override
    public ResponseEntity<ProductDTO> getProduct(UUID productId) {
        return ResponseEntity.ok(ps.getById(productId));
    }

    @Override
    public ResponseEntity<ProductDTO> createProduct(ProductDTO productDTO) {
        return ResponseEntity.ok(ps.create(productDTO));
    }
}
