package ua.transkyy.curconv.model;

import java.math.BigDecimal;

public record ExchangeParams(String from, String to, BigDecimal amount) {}
