package vlad.way.order.service.service.gateway;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import vlad.way.order.service.grpc.InventoryGrpc;
import vlad.way.order.service.service.gateway.v1.InventoryGatewayRest;
import vlad.way.order.service.service.gateway.v2.InventoryGatewayGrpc;

@Configuration
public class ConfigGateway {

    @Value("${inventory.grpc.url}")
    private String inventoryServiceUrl;


    @Bean
    @ConditionalOnProperty(name = "inventory.provider", havingValue = "rest")
    public InventoryGateway restGateway(RestClient restClient){
        return new InventoryGatewayRest(restClient);
    }

    @Bean
    @ConditionalOnProperty(name = "inventory.provider", havingValue = "grpc", matchIfMissing = true)
    public InventoryGateway grpcGateway(){
        ManagedChannel channel = ManagedChannelBuilder
                .forTarget(inventoryServiceUrl)
                .usePlaintext()
                .build();
        InventoryGrpc.InventoryBlockingStub stub =
                InventoryGrpc.newBlockingStub(channel);
        return new InventoryGatewayGrpc(stub);
    }




}
