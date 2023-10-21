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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import ua.transkyy.curconv.model.Exchange;
import ua.transkyy.curconv.service.ApiService;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class CurrencyControllerTest {

//    private final String apiAccessKey = "83da015792132e39cf61afcfda1aa4f2";
//
//    @Autowired
//    private WebTestClient webTestClient;
//
//    @MockBean
//    private ApiService apiService;
//
//    @Test
//    public void testExchange() {
//
//        String apiUrl = "http://localhost:8333/convert?from=EUR&to=USD&amount=100";
//
//        Exchange mockExchange = new Exchange();
//        mockExchange.setSuccess(true);
//        mockExchange.setResult(BigDecimal.valueOf(105.6145));
//
//        when(apiService.fetchDataWithParams(
//                "USD",
//                "EUR",
//                BigDecimal.valueOf(100),
//                apiAccessKey
//        )).thenReturn(Mono.just(mockExchange));
//
//        webTestClient.get()
//                .uri(apiUrl)
//                .exchange()
//                .expectStatus().isOk()
//                .expectBody()
//                .jsonPath("success").isEqualTo(true)
//                .jsonPath("result").isEqualTo(102);
//
//
////        webTestClient.get()
////                .
//    }


//    private CurrencyController currencyController;
//
//    @Mock
//    private RestTemplate restTemplate;
//
//    @BeforeEach
//    public void init() {
//
//        MockitoAnnotations.openMocks(this);
//        currencyController = new CurrencyController(restTemplate);
//    }
//
//    @Test
//    public void testExchange() {
//        String apiUrl = "http://localhost:8333/convert?from=EUR&to=USD&amount=100";
//
//        Exchange exchangeResult = new Exchange();
//        exchangeResult.setSuccess(true);
//        exchangeResult.setResult(BigDecimal.valueOf(105.6145));
//
//        Mockito.when(restTemplate.getForEntity(apiUrl, Exchange.class))
//                .thenReturn(new ResponseEntity<>(exchangeResult, HttpStatus.OK));
//
//        ResponseEntity<Exchange> result = currencyController.exchange(
//                "USD",
//                "EUR",
//                BigDecimal.valueOf(100)
//        );
//
//        assertEquals(HttpStatus.OK, result.getStatusCode());
////        assertEquals(exchangeResult.getResult(), result.getBody().getResult());
//        assertEquals(true, result.getBody().getSuccess());
//
//    }
}
