package com.dk0124.cdr.persistence.dto.upbit.orderbook;

import com.dk0124.cdr.persistence.entity.upbit.orderbook.OrderBookUnit;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UpbitOrderbookDto {
    @NotNull
    @JsonProperty("market")
    @JsonAlias("code")
    private String code;

    @NotNull
    @JsonProperty("timestamp")
    private Long timestamp;

    @JsonProperty("total_ask_size")
    private Double totalAskSize;

    @JsonProperty("total_bid_size")
    private Double totalBidSize;

    @JsonProperty("orderbook_units")
    private List<OrderBookUnit> orderBookUnits;
}
