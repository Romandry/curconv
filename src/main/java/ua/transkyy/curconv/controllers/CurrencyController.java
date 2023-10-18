package ua.transkyy.curconv.controllers;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import ua.transkyy.curconv.model.Exchange;

@RestController
public class CurrencyController {

    private final String BASE_URL = "http://api.exchangerate.host/convert";

    // TODO: Разобраться. Не проходит в тестах
//    @Value("${api.access_key}")
//    private String apiAccessKey;
    private final String apiAccessKey = "83da015792132e39cf61afcfda1aa4f2";

    private RestTemplate restTemplate;

    public CurrencyController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/convert")
    public ResponseEntity<Exchange> exchange(
            @RequestParam(name = "from") String currencyFrom,
            @RequestParam(name = "to") String currencyTo,
            @RequestParam(name = "amount") BigDecimal amount
    ) {

        String apiUrl = BASE_URL + "?from=" + currencyFrom + "&to=" + currencyTo + "&amount=" + amount + "&access_key=" + apiAccessKey;

        RestTemplate restTemplate = new RestTemplate();

        // TODO: try-catch
        ResponseEntity<Exchange> result = restTemplate.getForEntity(apiUrl, Exchange.class);

        return ResponseEntity.ok().body(result.getBody());
    }
}

/*



 */
