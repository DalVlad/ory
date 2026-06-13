package vlad.way.inventory.service.controller;

import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import vlad.way.inventory.service.dto.ProductDTO;

import java.util.UUID;

@RestController("/api/inventory")
public interface ProductController {

    @GetMapping("/{productId}")
    ResponseEntity<ProductDTO> getProduct(@PathParam("productId") UUID productId);

    @PostMapping
    ResponseEntity<ProductDTO> createProduct(@RequestBody ProductDTO productDTO);

}
