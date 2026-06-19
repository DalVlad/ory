package vlad.way.order.service.service.gateway.v1;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestClient;
import vlad.way.order.service.dto.response.InventoryResponse;
import vlad.way.order.service.service.gateway.InventoryGateway;

import java.util.UUID;

@RequiredArgsConstructor
@Slf4j
public class InventoryGatewayRest implements InventoryGateway {

    private final RestClient inventoryClient;
    @Value("${inventory.get.product}")
    private String uriGetProduct;

    public InventoryResponse getInventory(UUID productId) {
        log.debug("Rest getInventory with productId={}", productId);

        return inventoryClient.get()
                .uri(uriGetProduct, productId)
                .retrieve()
                .body(InventoryResponse.class);
    }

}
