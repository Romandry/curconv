package ua.transkyy.curconv.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.web.reactive.server.WebTestClient;

@Configuration
public class CurrencyConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    public WebTestClient webTestClient() {
//        return WebTestClient.bindToController().build();
//    }
}
