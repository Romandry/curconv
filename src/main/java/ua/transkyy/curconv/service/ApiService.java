package ua.transkyy.curconv.service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.model.Exchange;

@Service
public class ApiService {
    private final String BASE_URL = "http://api.exchangerate.host/convert";
    private final WebClient webClient;

    @Autowired
    public ApiService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(BASE_URL).build();
    }

    public Mono<Exchange> fetchDataWithParams(
            String currencyFrom,
            String currencyTo,
            BigDecimal amount,
            String apiAccessKey
    ) {
        return webClient.get()
                .uri(
                        "?from={currencyFrom}&to={currencyTo}&amount={amount}&access_key={apiAccessKey}",
                        currencyFrom, currencyTo, amount, apiAccessKey
                )
                .retrieve()
                .bodyToMono(Exchange.class);
    }
}
