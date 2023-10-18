package ua.transkyy.curconv.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.Objects;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.web.client.RestTemplate;
import ua.transkyy.curconv.model.Exchange;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class CurrencyControllerTest {

    private CurrencyController currencyController;

    @Mock
    private RestTemplate restTemplate;

    @BeforeEach
    public void init() {

        MockitoAnnotations.openMocks(this);
        currencyController = new CurrencyController(restTemplate);
    }

    @Test
    public void testExchange() {
        String apiUrl = "http://localhost:8333/convert?from=EUR&to=USD&amount=100";

        Exchange exchangeResult = new Exchange();
        exchangeResult.setSuccess(true);
        exchangeResult.setResult(BigDecimal.valueOf(105.6145));

        Mockito.when(restTemplate.getForEntity(apiUrl, Exchange.class))
                .thenReturn(new ResponseEntity<>(exchangeResult, HttpStatus.OK));

        ResponseEntity<Exchange> result = currencyController.exchange(
                "USD",
                "EUR",
                BigDecimal.valueOf(100)
        );

        assertEquals(HttpStatus.OK, result.getStatusCode());
//        assertEquals(exchangeResult.getResult(), result.getBody().getResult());
        assertEquals(true, result.getBody().getSuccess());

    }
}
