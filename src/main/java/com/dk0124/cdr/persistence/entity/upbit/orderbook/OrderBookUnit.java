package com.dk0124.cdr.persistence.entity.upbit.orderbook;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class OrderBookUnit implements Serializable {
    @JsonAlias("ask_price")
    private Double askPrice;
    @JsonAlias("bid_price")
    private Double bidPrice;

    @JsonAlias("ask_size")
    private Double askSize;
    @JsonAlias("bid_size")
    private Double bidSize;
}
