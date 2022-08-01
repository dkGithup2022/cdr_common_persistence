package com.dk0124.cdr.dto.upbit.candle;


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
    @JsonProperty("timestamp")
    private Long timestamp;

    @NotNull
    @JsonProperty("cd")
    @JsonAlias({"code","market"})
    private String market;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("candle_date_time_utc")
    private Date candleDateTimeUtc;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("candle_date_time_kst")
    private Date candleDateTimeKst;

    @JsonProperty("opening_price")
    private Double openingPrice;

    @JsonProperty("high_price")
    private Double highPrice;

    @JsonProperty("low_price")
    private Double lowPrice;

    @JsonProperty("trade_price")
    private Double tradePrice;

    @JsonProperty("candle_acc_trade_price")
    private Double candleAccTradePrice;

    @JsonProperty("candle_acc_trade_volume")
    private Double candleAccTradeVolume;
}
