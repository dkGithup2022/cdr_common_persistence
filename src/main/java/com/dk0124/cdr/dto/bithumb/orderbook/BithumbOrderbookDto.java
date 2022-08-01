package com.dk0124.cdr.dto.bithumb.orderbook;

import com.dk0124.cdr.entity.bithumb.orderbook.BithumbOrderbookUnit;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class BithumbOrderbookDto {
    @JsonProperty("datetime")
    private Long datetime;

    @JsonProperty("code")
    @JsonAlias("symbol")
    private String code;

    @JsonProperty("orderbookUnit")
    private List<BithumbOrderbookUnit> orderbookUnits;
}
