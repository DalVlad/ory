package vlad.way.order.service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class RestClientConfig {

    @Value("${inventory.serves.url}")
    private String inventoryServes;

    @Bean
    public RestClient inventoryClient() {
        return RestClient.builder()
                .baseUrl(inventoryServes)
                .build();
    }

}
