package com.dk0124.cdr.entity.bithumb.orderbook.message;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BithumbOrderbookUnitMessage {

    @JsonProperty("code")
    @JsonAlias("symbol")
    private String code;

    @JsonProperty("orderType")
    private String orderType;

    @JsonProperty("price")
    private Double price;

    @JsonProperty("quantity")
    private Double quantity;

    @JsonProperty("total")
    private Double total;
}
