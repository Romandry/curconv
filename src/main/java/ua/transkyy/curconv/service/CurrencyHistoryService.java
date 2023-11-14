package ua.transkyy.curconv.service;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.entity.CurrencyHistory;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.model.ExchangeParams;
import ua.transkyy.curconv.repository.CurrencyHistoryRepository;

@Service
public class CurrencyHistoryService {

    @Autowired
    private CurrencyHistoryRepository historyRepository;

    public void saveCurrencyHistory(CurrencyHistory currencyHistory) {
        historyRepository.save(currencyHistory);
    }

    public Mono<CurrencyHistory> createCurrencyHistory(ExchangeParams params, Mono<Exchange> result) {

        return result.map(exchange -> {
            CurrencyHistory currencyHistory = new CurrencyHistory();
            currencyHistory.setCurrencyFrom(params.from());
            currencyHistory.setCurrencyTo(params.to());
            currencyHistory.setAmount(exchange.result());
            return currencyHistory;
        });

    }

}
