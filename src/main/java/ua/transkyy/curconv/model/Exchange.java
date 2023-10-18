package ua.transkyy.curconv.model;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Exchange {

    private Boolean success;

    // Result from API
    private BigDecimal result;
}
