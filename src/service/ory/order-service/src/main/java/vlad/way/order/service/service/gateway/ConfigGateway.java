package vlad.way.order.service.service.gateway;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import vlad.way.order.service.service.gateway.v1.InventoryGatewayRest;
import vlad.way.order.service.service.gateway.v2.InventoryGatewayGrpc;

@Configuration
public class ConfigGateway {


    @Bean
    @ConditionalOnProperty(name = "inventory.provider", havingValue = "rest")
    public InventoryGateway restGateway(RestClient restClient){
        return new InventoryGatewayRest(restClient);
    }

    @Bean
    @ConditionalOnProperty(name = "inventory.provider", havingValue = "grpc", matchIfMissing = true)
    public InventoryGateway grpcGateway(){
        return new InventoryGatewayGrpc();
    }




}
