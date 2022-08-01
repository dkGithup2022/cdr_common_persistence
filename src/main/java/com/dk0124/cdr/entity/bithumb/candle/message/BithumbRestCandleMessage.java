package com.dk0124.cdr.entity.bithumb.candle.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class BithumbRestCandleMessage {

    @JsonProperty("status")
    private String status;

    @JsonProperty("data")
    private Object[] data;
}
