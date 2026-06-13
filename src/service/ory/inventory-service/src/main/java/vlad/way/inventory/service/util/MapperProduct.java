package vlad.way.inventory.service.util;

import org.springframework.stereotype.Component;
import vlad.way.inventory.service.dto.ProductDTO;
import vlad.way.inventory.service.entity.Product;

@Component
public class MapperProduct {

    public ProductDTO mapToDTO(Product product){
        return new ProductDTO(product.getId(), product.getAmount());
    }

    public Product mapToEntity(ProductDTO product){
        return new Product(product.id(), product.amount());
    }

}
