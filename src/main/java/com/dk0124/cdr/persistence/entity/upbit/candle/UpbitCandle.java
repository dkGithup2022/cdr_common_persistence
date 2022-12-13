package com.dk0124.cdr.persistence.entity.upbit.candle;

import com.dk0124.cdr.persistence.entity.abstraction.Candle;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@EqualsAndHashCode(of = "id")
public class UpbitCandle implements Serializable, Candle {

    public UpbitCandle(Long timestamp,
                       String market,
                       Date candleDateTimeUtc,
                       Date candleDateTimeKst,
                       Double openingPrice,
                       Double highPrice,
                       Double lowPrice,
                       Double tradePrice,
                       Double candleAccTradePrice,
                       Double candleAccTradeVolume){

        this.timestamp = timestamp;
        this.market = market;
        this.candleDateTimeUtc = candleDateTimeUtc;
        this.candleDateTimeKst = candleDateTimeKst;
        this.openingPrice = openingPrice;
        this.highPrice = highPrice;
        this.lowPrice = lowPrice;
        this.tradePrice=tradePrice;
        this.candleAccTradePrice = candleAccTradePrice;
        this.candleAccTradeVolume = candleAccTradeVolume;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @NotNull
    @JsonAlias("timestamp")
    private Long timestamp;

    @NotNull
    @JsonAlias({"code","market","cd"})
    private String market;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonAlias("candle_date_time_utc")
    private  Date candleDateTimeUtc;

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
