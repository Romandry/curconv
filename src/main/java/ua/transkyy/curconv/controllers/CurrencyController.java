package ua.transkyy.curconv.controllers;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.service.ApiService;

@RestController
public class CurrencyController {
    private final String apiAccessKey = "83da015792132e39cf61afcfda1aa4f2";

    private  final ApiService apiService;

    @Autowired
    public CurrencyController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/convert")
    public Mono<Exchange> exchange(
            @RequestParam(name = "from") String currencyFrom,
            @RequestParam(name = "to") String currencyTo,
            @RequestParam(name = "amount") BigDecimal amount
    ) {

        return apiService.fetchDataWithParams(
                currencyFrom,
                currencyTo,
                amount,
                apiAccessKey
        );
    }
}
