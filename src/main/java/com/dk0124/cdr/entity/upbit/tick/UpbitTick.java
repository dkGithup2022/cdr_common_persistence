package com.dk0124.cdr.entity.upbit.tick;

import com.dk0124.cdr.entity.abstraction.Ticks;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.dk0124.cdr.entity.upbit.CallType;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@MappedSuperclass
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode(of = "id")
public class UpbitTick implements Ticks {

    @Id
    @NotNull
    @JsonProperty("sid")
    @JsonAlias("sequential_id")
    private Long sequentialId;

    @JsonProperty("cd")
    @JsonAlias({"code","market"})
    private String code;

    @JsonProperty("ty")
    @JsonAlias("type")
    private String type;

    @JsonProperty("tp")
    @JsonAlias("trade_price")
    private Double tradePrice;

    @JsonProperty("tv")
    @JsonAlias("trade_volume")
    private Double tradeVolume;

    @JsonProperty("ab")
    @JsonAlias("ask_bid")
    private String askBid;

    @JsonProperty("pcp")
    @JsonAlias("prev_closing_price")
    private Double prev_closing_price;

    @JsonProperty("c")
    @JsonAlias("change")
    private String change;

    @JsonProperty("cp")
    @JsonAlias("change_price")
    private Double change_price;

    @JsonProperty("td")
    @JsonAlias({"trade_date","trade_date_utc"})
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tradeDateUtc;

    @JsonProperty("ttm")
    @JsonAlias({"trade_time","trade_time_utc"})
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date tradeTimeUtc;

    @JsonProperty("ttms")
    @JsonAlias("trade_timestamp")
    private Long tradeTimestamp;

    @JsonProperty("tms")
    @JsonAlias("timestamp")
    private Long timestamp;

    @JsonProperty("st")
    @JsonAlias("stream_type")
    private String streamType;

    private CallType callType;
}
