package vlad.way.inventory.service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vlad.way.inventory.service.dto.ProductDTO;

import java.util.UUID;

@RestController
@RequestMapping("/api/inventory")
public interface ProductController {

    @GetMapping("/{productId}")
    ResponseEntity<ProductDTO> getProduct(@PathVariable("productId") UUID productId);

    @PostMapping
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO);

}
