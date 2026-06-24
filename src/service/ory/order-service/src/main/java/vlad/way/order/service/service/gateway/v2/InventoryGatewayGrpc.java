package vlad.way.order.service.service.gateway.v2;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import vlad.way.order.service.dto.response.InventoryResponse;
import vlad.way.order.service.grpc.InventoryGrpc;
import vlad.way.order.service.grpc.InventoryRequest;
import vlad.way.order.service.service.gateway.InventoryGateway;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class InventoryGatewayGrpc implements InventoryGateway {

    private final InventoryGrpc.InventoryBlockingStub stub;

    @Override
    public InventoryResponse getInventory(UUID productId) {
        log.debug("Grpc getInventory with productId={}", productId);
        InventoryRequest request = InventoryRequest.newBuilder()
                .setProductId(productId.toString())
                .build();

        var response = stub.getProduct(request);

        return new InventoryResponse(
                UUID.fromString(response.getProductId()),
                response.getAmount()
        );
    }
}
