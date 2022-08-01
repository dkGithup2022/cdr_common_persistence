package com.dk0124.cdr.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class OrderBookUnit implements Serializable {
    @JsonProperty("ask_price")
    private Double askPrice;
    @JsonProperty("bid_price")
    private Double bidPrice;

    @JsonProperty("ask_size")
    private Double askSize;
    @JsonProperty("bid_size")
    private Double bidSize;
}
