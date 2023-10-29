package ua.transkyy.curconv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.model.ExchangeParams;
import ua.transkyy.curconv.service.ApiService;

@RestController
public class CurrencyController {

    @Value("${api.access_key}")
    private String apiAccessKey;

    private  final ApiService apiService;

    @Autowired
    public CurrencyController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/convert")
    public Mono<Exchange> exchange(ExchangeParams params) {
        return apiService.fetchDataWithParams(params, apiAccessKey);
    }
}
