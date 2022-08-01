package com.dk0124.cdr.entity.bithumb.orderbook.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BithumbOrderbookSocketMessage {

    @JsonProperty("type")
    private String type;

    @JsonProperty("content")
    private  BithumbOrderbookListMessage content;

    @JsonProperty("status")
    private String status;

    @JsonProperty("resmsg")
    private String resmsg;
}
