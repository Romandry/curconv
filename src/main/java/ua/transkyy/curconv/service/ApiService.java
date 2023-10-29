package ua.transkyy.curconv.service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.model.ExchangeParams;

@Service
public class ApiService {
    private final String BASE_URL = "http://api.exchangerate.host";
    private final WebClient webClient;

    @Autowired
    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public Mono<Exchange> fetchDataWithParams(
            ExchangeParams exchangeParams,
            String apiAccessKey
    ) {
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString("/convert");
        builder.queryParam("from", exchangeParams.from());
        builder.queryParam("to", exchangeParams.to());
        builder.queryParam("amount", exchangeParams.amount());
        builder.queryParam("access_key", apiAccessKey);

        return webClient.get()
                .uri(builder.toUriString())
                .retrieve()
                .bodyToMono(Exchange.class);
    }
}
