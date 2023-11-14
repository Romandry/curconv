package ua.transkyy.curconv.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.entity.CurrencyHistory;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.model.ExchangeParams;
import ua.transkyy.curconv.service.ApiService;
import ua.transkyy.curconv.service.CurrencyHistoryService;

@RestController
public class CurrencyController {

    @Value("${api.access_key}")
    private String apiAccessKey;

    private final ApiService apiService;

    private final CurrencyHistoryService historyService;

    @Autowired
    public CurrencyController(
            ApiService apiService,
            CurrencyHistoryService historyService) {
        this.apiService = apiService;
        this.historyService = historyService;
    }

    public CurrencyController(
            ApiService apiService,
            String apiAccessKey,
            CurrencyHistoryService historyService) {
        this.apiService = apiService;
        this.apiAccessKey = apiAccessKey;
        this.historyService = historyService;
    }

    @GetMapping("/convert")
    public Mono<Exchange> exchange(ExchangeParams params) {
        return apiService.fetchDataWithParams(params, apiAccessKey);
    }

    // Convert and Save
    @GetMapping("/save")
    public Mono<ResponseEntity> convertAndSave(ExchangeParams params) {
        Mono<Exchange> result = apiService.fetchDataWithParams(params, apiAccessKey);

        return historyService.createCurrencyHistory(params, result)
                .doOnNext(historyService::saveCurrencyHistory)
                .thenReturn(ResponseEntity.ok(HttpStatus.OK));

//        CurrencyHistory currencyHistory = historyService.createCurrencyHistory(params, result);
//        historyService.saveCurrencyHistory(currencyHistory);
//        return ResponseEntity.ok(HttpStatus.OK);


    }

}
