package com.dk0124.cdr.persistence.entity.upbit.tick;

import com.dk0124.cdr.persistence.entity.abstraction.Ticks;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import com.dk0124.cdr.persistence.entity.upbit.CallType;
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
    @JsonAlias({"sequential_id","sid"})
    // upbit tick 의 아이디 값은 Upbit 에서 제공함.
    private Long sequentialId;

    @JsonAlias({"code","market","cd"})
    private String code;

    @JsonAlias({"type","ty"})
    private String type;

    @JsonAlias({"trade_price","tp"})
    private Double tradePrice;

    @JsonAlias({"trade_volume","tv"})
    private Double tradeVolume;

    @JsonAlias({"ask_bid","ab"})
    private String askBid;

    @JsonAlias({"prev_closing_price",("pcp")})
    private Double prevClosingPrice;

    @JsonAlias({"change","c"})
    private String change;

    @JsonAlias({"change_price","cp"})
    private Double changePrice;

    @JsonAlias({"trade_date","trade_date_utc","td"})
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tradeDateUtc;

    @JsonAlias({"trade_time","trade_time_utc","ttm"})
    @Temporal(TemporalType.TIMESTAMP)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date tradeTimeUtc;

    @JsonAlias({"trade_timestamp","ttms"})
    private Long tradeTimestamp;

    @JsonAlias({"timestamp","tms"})
    private Long timestamp;

    @JsonAlias({"stream_type","st"})
    private String streamType;

    private CallType callType;
}
