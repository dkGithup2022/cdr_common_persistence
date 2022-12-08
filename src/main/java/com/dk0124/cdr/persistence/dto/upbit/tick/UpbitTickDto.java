package com.dk0124.cdr.persistence.dto.upbit.tick;


import com.dk0124.cdr.persistence.entity.upbit.CallType;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UpbitTickDto {

    @NotNull
    @JsonAlias({"sequential_id","sid"})
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

    @JsonAlias({"prev_closing_price","pcp"})
    private Double prev_closing_price;

    @JsonAlias({"change","c"})
    private String change;

    @JsonAlias({"change_price","cp"})
    private Double change_price;

    @JsonAlias({"trade_date","trade_date_utc","td"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tradeDateUtc;

    @JsonAlias({"trade_time","trade_time_utc","ttm"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date tradeTimeUtc;

    @JsonAlias({"trade_timestamp","ttms"})
    private Long tradeTimestamp;

    @JsonAlias({"timestamp","tms"})
    private Long timestamp;

    @JsonAlias({"stream_type","st"})
    private String streamType;

    @JsonIgnore
    private CallType callType;
}
