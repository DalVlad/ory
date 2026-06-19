package vlad.way.order.service.service.gateway.v2;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.grpc.client.ImportGrpcClients;
import org.springframework.stereotype.Service;
import vlad.way.order.service.dto.response.InventoryResponse;
import vlad.way.order.service.grpc.InventoryGrpc;
import vlad.way.order.service.grpc.InventoryRequest;
import vlad.way.order.service.service.gateway.InventoryGateway;

import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
public class InventoryGatewayGrpc implements InventoryGateway {
    @Value("${inventory.grpc.url}")
    private String inventoryServiceUrl;

    @Override
    public InventoryResponse getInventory(UUID productId) {
        log.debug("Grpc getInventory with productId={}", productId);

        ManagedChannel channel = ManagedChannelBuilder
                .forTarget(inventoryServiceUrl)
                .usePlaintext()
                .build();

        try {
            InventoryGrpc.InventoryBlockingStub stub =
                    InventoryGrpc.newBlockingStub(channel);

            InventoryRequest request = InventoryRequest.newBuilder()
                    .setProductId(productId.toString())
                    .build();

            var response = stub.getProduct(request);

            return new InventoryResponse(
                    UUID.fromString(response.getProductId()),
                    response.getAmount()
            );
        } finally {
            channel.shutdown();
        }
    }
}
