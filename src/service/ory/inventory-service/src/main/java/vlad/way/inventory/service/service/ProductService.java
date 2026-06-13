package vlad.way.inventory.service.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vlad.way.inventory.service.dto.ProductDTO;
import vlad.way.inventory.service.entity.Product;
import vlad.way.inventory.service.exception.ProductNotFoundException;
import vlad.way.inventory.service.repository.ProductRepository;
import vlad.way.inventory.service.util.MapperProduct;


import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    private final ProductRepository pr;
    private final MapperProduct mp;

    @Transactional
    public ProductDTO create(ProductDTO product) {
        Product saveProduct = pr.save(mp.mapToEntity(product));
        return mp.mapToDTO(saveProduct);
    }

    public List<ProductDTO> getAll() {
        return pr.findAll().stream().map(mp::mapToDTO).toList();
    }

    public ProductDTO getById(UUID id) {
        Product product = pr.findById(id).orElseThrow(() -> new ProductNotFoundException("Product with id not found"));
        return mp.mapToDTO(product);
    }

    @Transactional
    public ProductDTO update(UUID id, ProductDTO product) {
        Product updateProduct = pr.findById(id)
                .map(existing -> {
                    existing.setAmount(product.amount());
                    return pr.save(existing);
                })
                .orElseThrow(() -> new ProductNotFoundException("Product with id not found"));
        return mp.mapToDTO(updateProduct);
    }

    @Transactional
    public void delete(UUID id) {
        pr.deleteById(id);
    }
}