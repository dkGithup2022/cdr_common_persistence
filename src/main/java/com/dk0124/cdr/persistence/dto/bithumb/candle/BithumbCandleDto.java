package com.dk0124.cdr.persistence.dto.bithumb.candle;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.sun.istack.NotNull;
import lombok.*;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;

@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class BithumbCandleDto {
    @NotEmpty
    @JsonAlias("code")
    private String code;

    @NotNull
    @JsonAlias("timestamp")
    public Long timestamp;

    @JsonAlias("opening_price")
    private Double openingPrice;

    @JsonAlias("closing_price")
    private Double closingPrice;

    @JsonAlias("high_price")
    private Double highPrice;

    @JsonAlias("low_price")
    private Double lowPrice;

    @JsonAlias("trade_amount")
    private Double tradeAmount;
}
