package ua.transkyy.curconv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.transkyy.curconv.repository.CurrencyRepository;

@Service
public class CurrencyService {

    @Autowired
    private CurrencyRepository currencyRepository;
//    private final CurrencyRepository currencyRepository;
//    public CurrencyService(CurrencyRepository currencyRepository) {
//        this.currencyRepository = currencyRepository;
//    }


}
