package com.dk0124.cdr.persistence.dto.upbit.tick;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class UpbitTickDto {

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
    private Double prevClosingPrice;

    @JsonAlias({"change","c"})
    private String change;

    @JsonAlias({"change_price","cp"})
    private Double changePrice;

    @JsonAlias({"trade_date","trade_date_utc","td"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date tradeDateUtc;

    @JsonAlias({"trade_time","trade_time_utc","ttm"})
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss")
    private Date tradeTimeUtc;

    @JsonAlias({"timestamp","tms"})
    private Long timestamp;

    @JsonAlias({"stream_type","st"})
    private String streamType;
}
