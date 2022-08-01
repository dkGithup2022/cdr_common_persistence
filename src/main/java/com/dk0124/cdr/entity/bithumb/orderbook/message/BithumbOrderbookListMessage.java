package com.dk0124.cdr.entity.bithumb.orderbook.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class BithumbOrderbookListMessage {

    @JsonProperty("list")
    private List<BithumbOrderbookUnitMessage> list;

    @JsonProperty("datetime")
    private Long datetime;
}
