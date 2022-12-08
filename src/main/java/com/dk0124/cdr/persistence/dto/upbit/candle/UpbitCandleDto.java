package com.dk0124.cdr.persistence.dto.upbit.candle;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UpbitCandleDto {
    @NotNull
    @JsonAlias("timestamp")
    private Long timestamp;

    @NotNull
    @JsonProperty("cd")
    @JsonAlias({"code","market"})
    private String market;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonAlias("candle_date_time_utc")
    private Date candleDateTimeUtc;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonAlias("candle_date_time_kst")
    private Date candleDateTimeKst;

    @JsonAlias("opening_price")
    private Double openingPrice;

    @JsonAlias("high_price")
    private Double highPrice;

    @JsonAlias("low_price")
    private Double lowPrice;

    @JsonAlias("trade_price")
    private Double tradePrice;

    @JsonAlias("candle_acc_trade_price")
    private Double candleAccTradePrice;

    @JsonAlias("candle_acc_trade_volume")
    private Double candleAccTradeVolume;
}
