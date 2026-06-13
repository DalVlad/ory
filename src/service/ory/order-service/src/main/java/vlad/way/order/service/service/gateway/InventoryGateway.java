package vlad.way.order.service.service.gateway;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import vlad.way.order.service.dto.response.InventoryResponse;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class InventoryGateway {

    private final RestClient inventoryClient;

    public InventoryResponse getInventory(UUID productId) {

        return inventoryClient.get()
                .uri("/inventory/{id}", productId)
                .retrieve()
                .body(InventoryResponse.class);
    }
}
