package com.dk0124.cdr.persistence.dto.bithumb.orderbook;

import com.dk0124.cdr.persistence.entity.bithumb.orderbook.BithumbOrderbookUnit;
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
    @JsonAlias("datetime")
    private Long datetime;

    @JsonAlias({"symbol","code"})
    private String code;

    @JsonAlias("orderbookUnit")
    private List<BithumbOrderbookUnit> orderbookUnits;
}
