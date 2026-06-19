package vlad.way.order.service.service.gateway;

import vlad.way.order.service.dto.response.InventoryResponse;

import java.util.UUID;

public interface InventoryGateway {


    InventoryResponse getInventory(UUID productId);

}
