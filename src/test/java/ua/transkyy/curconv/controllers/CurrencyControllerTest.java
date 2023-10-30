package ua.transkyy.curconv.controllers;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.model.ExchangeParams;
import ua.transkyy.curconv.service.ApiService;

@RunWith(MockitoJUnitRunner.class)
public class CurrencyControllerTest {

    @Value("${api.access_key}")
    private String apiAccessKey;

    @Mock
    private ApiService apiServiceMock;

    @InjectMocks
    private CurrencyController currencyController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        currencyController = new CurrencyController(apiServiceMock, apiAccessKey);
    }

    @Test
    public void testExchange() {
        //given
        ExchangeParams params = new ExchangeParams("USD", "EUR", new BigDecimal("100"));
        Exchange expectedExchange = new Exchange(true, new BigDecimal("2.000"));

        //when
        when(apiServiceMock.fetchDataWithParams(eq(params), eq(apiAccessKey)))
                .thenReturn(Mono.just(expectedExchange));
        Mono<Exchange> result = currencyController.exchange(params);

        //then
        verify(apiServiceMock).fetchDataWithParams(eq(params), eq(apiAccessKey));

        Exchange actualExchange = result.block();
        assertThat(actualExchange).isEqualToComparingFieldByFieldRecursively(expectedExchange);
    }

}
