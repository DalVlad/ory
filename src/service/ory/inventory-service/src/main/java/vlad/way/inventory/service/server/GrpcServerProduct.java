package vlad.way.inventory.service.server;

import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.grpc.server.service.GrpcService;
import vlad.way.inventory.service.dto.ProductDTO;
import vlad.way.inventory.service.service.ProductService;
import vlad.way.order.service.grpc.InventoryGrpc;
import vlad.way.order.service.grpc.InventoryRequest;
import vlad.way.order.service.grpc.InventoryResponse;

import java.util.UUID;

@Slf4j
@GrpcService
@RequiredArgsConstructor
public class GrpcServerProduct extends InventoryGrpc.InventoryImplBase {

    private final ProductService ps;

    @Override
    public void getProduct(InventoryRequest request, StreamObserver<InventoryResponse> responseObserver) {
        log.debug("Get product by id: {}", request.getProductId());
        UUID productId = UUID.fromString(request.getProductId());
        ProductDTO productDTO = ps.getById(productId);
        InventoryResponse response = InventoryResponse.newBuilder()
                .setProductId(productDTO.id().toString())
                .setAmount(productDTO.amount())
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
